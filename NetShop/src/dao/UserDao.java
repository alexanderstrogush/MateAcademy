package dao;

import com.google.gson.Gson;
import model.Cart;
import model.User;
import org.apache.log4j.Logger;
import utils.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class UserDao {

    private static final Logger logger = Logger.getLogger(UserDao.class);
    private static final Connection connection = ConnectionUtil.connect();

    public long addUser(User user) {
        try {
            final String insertQuery = "INSERT INTO users (username, first_name, last_name, email, password, role, cart, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, HashUtil.getSHA512SecurePassword(user.getPassword(), user.getSalt()));
            preparedStatement.setInt(6, user.getRoleNumber());
            preparedStatement.setString(7, user.getStringCart());
            preparedStatement.setString(8, user.getSalt());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in addUserQuery", e);
        }
        return -1;
    }

    public void updateUser(long user_id, User user) {
        final String updateQuery = "UPDATE users SET username = ?, first_name = ?, last_name = ?, email = ?, password = ?, role = ?, cart = ? WHERE user_id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRoleNumber());
            statement.setString(7, user.getStringCart());
            statement.setLong(8, user_id);
            statement.executeUpdate();
            logger.debug("Executed query: " + statement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in updateUserQuery", e);
        }
    }

    public void deleteUser(long user_id) {
        try {
            String deleteUserQuery = "DELETE FROM users WHERE user_id = ?;";
            PreparedStatement statement = connection.prepareStatement(deleteUserQuery);
            statement.setLong(1, user_id);
            statement.executeUpdate();
            logger.debug("Executed query: " + statement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in deleteUserQuery", e);
        }
    }

    public Optional<User> getUserByUserID(long id) {
        try {
            final String getQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt " +
                    "FROM users INNER JOIN roles ON users.role = roles.role_id " +
                    "WHERE users.user_id = ?;";
            PreparedStatement statement = connection.prepareStatement(getQuery);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            logger.debug("Executed query: " + statement.toString());
            if (result.next()) {
                String username = result.getString("username");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");
                String cartString = result.getString("cart");
                String salt = result.getString("salt");

                Gson gson = new Gson();
                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
                Cart cart = Cart.createCart(cartMap);

                return Optional.of(new User(id, username, firstName, lastName, email, password, cart, role, salt));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getUserQuery", e);
        }
        return Optional.empty();
    }

    public Optional<User> getUserByUsername(String username) {
        try {
            final String getQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt " +
                    "FROM users INNER JOIN roles ON users.role = roles.role_id " +
                    "WHERE users.username = ?;";
            PreparedStatement statement = connection.prepareStatement(getQuery);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            logger.debug("Executed query: " + statement.toString());
            if (result.next()) {
                Long id = result.getLong("user_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");
                String cartString = result.getString("cart");
                String salt = result.getString("salt");

                Gson gson = new Gson();
                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
                Cart cart = Cart.createCart(cartMap);

                return Optional.of(new User(id, username, firstName, lastName, email, password, cart, role, salt));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getUserQuery", e);
        }
        return Optional.empty();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> resultList = new ArrayList<>();
        User tempUser;
        Gson gson = new Gson();
        try {
            final String getAllQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt FROM users INNER JOIN roles ON users.role = roles.role_id;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getAllQuery);
            logger.debug("Executed query: " + statement.toString());
            while (result.next()) {
                int user_id = result.getInt("user_id");
                String username = result.getString("username");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role_name");
                String cartString = result.getString("cart");
                String salt = result.getString("salt");

                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
                Cart cart = Cart.createCart(cartMap);
                tempUser = new User(user_id, username, firstName, lastName, email, password, cart, role, salt);
                resultList.add(tempUser);
            }
        } catch (SQLException e) {
            logger.error("SQL error in getAllUsersQuery", e);
        }
        return resultList;
    }
}