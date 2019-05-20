package com.shop.dao;

import com.shop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

public class UserDao {

    private static final Connection connection = ConnectionUtil.connect();

    public void addUser(User user) {
        try {
            final String insertQuery = "INSERT INTO users (username, first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getRoleNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int user_id, User user) {
        final String updateQuery = "UPDATE users SET username = ?, first_name = ?, last_name = ?, email = ?, password = ?, role = ? WHERE user_id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRoleNumber());
            statement.setInt(7, user_id);
            statement.executeUpdate();
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

    public Optional<User> getUserByUserID(int id) {
        try {
            final String getQuery = "SELECT user_id, username, first_name, last_name, email, password, role_name FROM users INNER JOIN roles ON users.role = roles.role_id WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(getQuery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String username = result.getString("username");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");

                return Optional.of(new User(id, username, firstName, lastName, email, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> getUserByUsername(String username) {
        try {
            final String getQuery = "SELECT user_id, username, first_name, last_name, email, password, role_name FROM users INNER JOIN roles ON users.role = roles.role_id WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(getQuery);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int user_id = result.getInt("user_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");

                return Optional.of(new User(user_id, username, firstName, lastName, email, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> resultList = new ArrayList<>();
        User tempUser;
        try {
            final String getAllQuery = "SELECT user_id, username, first_name, last_name, email, password, role_name FROM users INNER JOIN roles ON users.role = roles.role_id;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getAllQuery);
            while (result.next()) {
                int user_id = result.getInt("user_id");
                String username = result.getString("username");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");
                tempUser = new User(user_id, username, firstName, lastName, email, password, role);
                resultList.add(tempUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}