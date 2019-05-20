//package com.shop.dao.implamentation.jdbc;
//
//import com.shop.dao.ConnectionUtil;
//import com.shop.dao.UserDao;
//import com.shop.model.User;
//import org.apache.log4j.Logger;
//
//import com.google.gson.Gson;
//import com.shop.model.Cart;
//import com.shop.utils.HashUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//public class UserDaoImpl {
//    public long addUser(User user) {
//        return 0;
//    }
//
//    public Optional<User> getUserById(long userId) {
//        return Optional.empty();
//    }
//
//    public Optional<User> getUserByUsername(String username) {
//        return Optional.empty();
//    }
//
//    public List<User> getAllUsers() {
//        return null;
//    }
//
//    public int deleteUserById(long userId) {
//        return 0;
//    }
//
//    public int updateUserById(long userId, User user) {
//        return 0;
//    }
//
//    //
////    private static final Logger logger = Logger.getLogger(UserDao.class);
////    private static final Connection connection = ConnectionUtil.connect();
////
////    @Override
////    public long addUser(User user) {
////        try {
////            String insertQuery = "INSERT INTO users (username, first_name, last_name, email, password, role, cart, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
////            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
////            preparedStatement.setString(1, user.getUsername());
////            preparedStatement.setString(2, user.getFirstName());
////            preparedStatement.setString(3, user.getLastName());
////            preparedStatement.setString(4, user.getEmail());
////            preparedStatement.setString(5, HashUtil.getSHA512SecurePassword(user.getPassword(), user.getSalt()));
//////            preparedStatement.setInt(6, user.getRoleNumber());
////            preparedStatement.setString(7, user.getStringCart());
////            preparedStatement.setString(8, user.getSalt());
////            preparedStatement.executeUpdate();
////            ResultSet resultSet = preparedStatement.getGeneratedKeys();
////            logger.debug("Executed query: " + preparedStatement.toString());
////            if (resultSet.next()) {
////                return resultSet.getLong(1);
////            }
////        } catch (SQLException e) {
////            logger.error("SQL error in addUserQuery", e);
////        }
////        return -1;
////    }
////
////    @Override
////    public Optional<User> getUserById(long userId) {
////        try {
////            String getQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt " +
////                    "FROM users INNER JOIN roles ON users.role = roles.role_id " +
////                    "WHERE users.user_id = ?;";
////            PreparedStatement statement = connection.prepareStatement(getQuery);
////            statement.setLong(1, userId);
////            ResultSet result = statement.executeQuery();
////            logger.debug("Executed query: " + statement.toString());
////            if (result.next()) {
////                String username = result.getString("username");
////                String firstName = result.getString("first_name");
////                String lastName = result.getString("last_name");
////                String email = result.getString("email");
////                String password = result.getString("password");
////                String role = result.getString("role_name");
////                String cartString = result.getString("cart");
////                String salt = result.getString("salt");
////
////                Gson gson = new Gson();
////                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
////                Cart cart = Cart.createCart(cartMap);
////
////                return Optional.of(new User(userId, username, firstName, lastName, email, password, cart, role, salt));
////            }
////        } catch (SQLException e) {
////            logger.error("SQL error in getUserQuery", e);
////        }
////        return Optional.empty();
////    }
////
////    @Override
////    public Optional<User> getUserByUsername(String username) {
////        try {
////            String getQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt " +
////                    "FROM users INNER JOIN roles ON users.role = roles.role_id " +
////                    "WHERE users.username = ?;";
////            PreparedStatement statement = connection.prepareStatement(getQuery);
////            statement.setString(1, username);
////            ResultSet result = statement.executeQuery();
////            logger.debug("Executed query: " + statement.toString());
////            if (result.next()) {
////                Long id = result.getLong("user_id");
////                String firstName = result.getString("first_name");
////                String lastName = result.getString("last_name");
////                String email = result.getString("email");
////                String password = result.getString("password");
////                String role = result.getString("role_name");
////                String cartString = result.getString("cart");
////                String salt = result.getString("salt");
////
////                Gson gson = new Gson();
////                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
////                Cart cart = Cart.createCart(cartMap);
////
////                return Optional.of(new User(id, username, firstName, lastName, email, password, cart, role, salt));
////            }
////        } catch (SQLException e) {
////            logger.error("SQL error in getUserQuery", e);
////        }
////        return Optional.empty();
////    }
////
////    @Override
////    public List<User> getAllUsers() {
////        List<User> resultList = new ArrayList<>();
////        User tempUser;
////        Gson gson = new Gson();
////        try {
////            String getAllQuery = "SELECT user_id, username, first_name, last_name, email, password, cart, role_name, salt FROM users INNER JOIN roles ON users.role = roles.role_id;";
////            Statement statement = connection.createStatement();
////            ResultSet result = statement.executeQuery(getAllQuery);
////            logger.debug("Executed query: " + statement.toString());
////            while (result.next()) {
////                int user_id = result.getInt("user_id");
////                String username = result.getString("username");
////                String firstName = result.getString("first_name");
////                String lastName = result.getString("last_name");
////                String email = result.getString("email");
////                String password = result.getString("password");
////                String role = result.getString("role_name");
////                String cartString = result.getString("cart");
////                String salt = result.getString("salt");
////
////                HashMap<String, String> cartMap = gson.fromJson(cartString, HashMap.class);
////                Cart cart = Cart.createCart(cartMap);
////                tempUser = new User(user_id, username, firstName, lastName, email, password, cart, role, salt);
////                resultList.add(tempUser);
////            }
////        } catch (SQLException e) {
////            logger.error("SQL error in getAllUsersQuery", e);
////        }
////        return resultList;
////    }
////
////    @Override
////    public int deleteUserById(long userId) {
////        int result = 0;
////        try {
////            String deleteUserQuery = "DELETE FROM users WHERE user_id = ?;";
////            PreparedStatement statement = connection.prepareStatement(deleteUserQuery);
////            statement.setLong(1, userId);
////            result = statement.executeUpdate();
////            logger.debug("Executed query: " + statement.toString());
////        } catch (SQLException e) {
////            logger.error("SQL error in deleteUserQuery", e);
////        }
////        return result;
////    }
////
////    @Override
////    public int updateUserById(long userId, User user) {
////        int result = 0;
////        String updateQuery = "UPDATE users SET username = ?, first_name = ?, last_name = ?, email = ?, role = ?, cart = ? WHERE user_id=?;";
////        try {
////            PreparedStatement statement = connection.prepareStatement(updateQuery);
////            statement.setString(1, user.getUsername());
////            statement.setString(2, user.getFirstName());
////            statement.setString(3, user.getLastName());
////            statement.setString(4, user.getEmail());
////            statement.setInt(5, user.getRoleNumber());
////            statement.setString(6, user.getStringCart());
////            statement.setLong(7, userId);
////            result = statement.executeUpdate();
////            logger.debug("Executed query: " + statement.toString());
////        } catch (SQLException e) {
////            logger.error("SQL error in updateUserQuery", e);
////        }
////        return result;
////    }
//}
