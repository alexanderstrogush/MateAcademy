//package com.shop.dao.implamentation.jdbc;
//
//import com.google.gson.Gson;
//import com.shop.dao.ConnectionUtil;
//import com.shop.dao.OrderDao;
//import com.shop.model.Good;
//import com.shop.model.Order;
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
//public class OrderDaoImpl implements OrderDao {
//
//    private static final Connection CONNECTION = ConnectionUtil.connect();
//
//    @Override
//    public long addOrder(Order order) {
//        String addOrderQuery = "INSERT INTO orders(user_id, goods, price, status) VALUES(?, ?, ?, ?);";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addOrderQuery, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setLong(1, order.getUserId());
//            preparedStatement.setString(2, order.getGoodsString());
//            preparedStatement.setDouble(3, order.getPrice());
//            preparedStatement.setString(4, order.getStatus());
//            preparedStatement.executeUpdate();
////            logger.debug("Executed query: " + preparedStatement.toString());
//            ResultSet orderIdResult = preparedStatement.getGeneratedKeys();
//            if (orderIdResult.next()) {
//                return orderIdResult.getLong(1);
//            }
//        } catch (SQLException e) {
////            logger.error("SQL error in addOrderQuery", e);
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    @Override
//    public Optional<Order> getOrderById(long orderId) {
//        String getOrderQuery = "SELECT * FROM orders WHERE order_id = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getOrderQuery);
//            preparedStatement.setLong(1, orderId);
//            ResultSet orderResultSet = preparedStatement.executeQuery();
////            logger.debug("Executed query: " + preparedStatement.toString());
//            if (orderResultSet.next()) {
//                long userId = orderResultSet.getLong("user_id");
//                String goodsString = orderResultSet.getString("goods");
//                Gson gson = new Gson();
//                HashMap<String, String> cartMap = gson.fromJson(goodsString, HashMap.class);
//                HashMap<Good, Integer> goods = Order.getGoodsMap(cartMap);
//                double price = orderResultSet.getDouble("price");
//                String status = orderResultSet.getString("status");
//
//                return Optional.of(new Order(orderId, userId, goods, price, status));
//            }
//        } catch (SQLException e) {
////            logger.error("SQL error in getOrderQuery", e);
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Order> getAllOrdersForUser(long userId) {
//        List<Order> result = new ArrayList<>();
//        String getAllOrdersQuery = "SELECT * FROM orders WHERE user_id = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getAllOrdersQuery);
//            preparedStatement.setLong(1, userId);
//            ResultSet ordersResultSet = preparedStatement.executeQuery();
//            while (ordersResultSet.next()) {
//                long orderId = ordersResultSet.getLong("order_id");
//                String goodsString = ordersResultSet.getString("goods");
//                Gson gson = new Gson();
//                HashMap<String, String> cartMap = gson.fromJson(goodsString, HashMap.class);
//                HashMap<Good, Integer> goods = Order.getGoodsMap(cartMap);
//                double price = ordersResultSet.getDouble("price");
//                String status = ordersResultSet.getString("status");
//                result.add(new Order(orderId, userId, goods, price, status));
//            }
//        } catch (SQLException e) {
////            logger.error("SQL error in getAllOrdersQuery", e);
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public int updateStatus(long orderId, String status) {
//        String updateOrderStatusQuery = "UPDATE orders SET status = ? WHERE order_id = ?;";
//        int result = 0;
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(updateOrderStatusQuery);
//            preparedStatement.setString(1, status);
//            preparedStatement.setLong(2, orderId);
//            result = preparedStatement.executeUpdate();
////            logger.debug("Executed query: " + preparedStatement.toString());
//        } catch (SQLException e) {
////            logger.error("SQL error in updateOrderQuery", e);
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public int deleteOrder(long orderId) {
//        String deleteOrderQuery = "DELETE FROM orders WHERE order_id = ?;";
//        int result = 0;
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(deleteOrderQuery);
//            preparedStatement.setLong(1, orderId);
//            result = preparedStatement.executeUpdate();
////            logger.debug("Executed query: " + preparedStatement.toString());
//        } catch (SQLException e) {
////            logger.error("SQL error in deleteOrderQuery", e);
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
