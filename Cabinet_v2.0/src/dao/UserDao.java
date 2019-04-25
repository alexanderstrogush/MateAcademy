package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Optional;

    public class UserDao {

        private static final Connection connection = ConnectionUtil.connect();

        public void addUser(User user) {
            try {
                final String insertQuery = "INSERT INTO users (username, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateUser(int user_id, User user) {
            final String updateQuery = "UPDATE users SET username=?, first_name=?, last_name=?, email=?, password=? WHERE user_id=?;";
            try {
                PreparedStatement statement = connection.prepareStatement(updateQuery);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getLastName());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getPassword());
                statement.setInt(6, user_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteUser(int user_id) {
            try {
                String sql = "DELETE FROM users WHERE user_id=?;";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, user_id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public Optional<User> getUser(String username) {
            try {
                final String getQuery = "SELECT * FROM users WHERE username=?";
                PreparedStatement statement = connection.prepareStatement(getQuery);
                statement.setString(1, username);
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    int user_id = result.getInt("user_id");
                    String firstName = result.getString("first_name");
                    String lastName = result.getString("last_name");
                    String email = result.getString("email");
                    String password = result.getString("password");

                    return Optional.of(new User(user_id, username, firstName, lastName, email, password));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }
    }
