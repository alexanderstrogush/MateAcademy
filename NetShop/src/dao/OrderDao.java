package dao;

import com.google.gson.Gson;
import model.Good;
import model.Order;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class OrderDao {

    private static final Logger logger = Logger.getLogger(OrderDao.class);
    private static final Connection CONNECTION = ConnectionUtil.connect();

    public long addOrder(Order order) {
        String addOrderQuery = "INSERT INTO orders(user_id, goods, price, status) VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addOrderQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, order.getUserId());
            preparedStatement.setString(2, order.getGoodsString());
            preparedStatement.setDouble(3, order.getPrice());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
            ResultSet orderIdResult = preparedStatement.getGeneratedKeys();
            if (orderIdResult.next()) {
                return orderIdResult.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("SQL error in addOrderQuery", e);
        }
        return -1;
    }

    public Optional<Order> getOrder(long orderId) {
        String getOrderQuery = "SELECT * FROM orders WHERE order_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getOrderQuery);
            preparedStatement.setLong(1, orderId);
            ResultSet orderResultSet = preparedStatement.executeQuery();
            logger.debug("Executed query: " + preparedStatement.toString());
            if (orderResultSet.next()) {
                long userId = orderResultSet.getLong("user_id");
                String goodsString = orderResultSet.getString("goods");
                Gson gson = new Gson();
                HashMap<String, String> cartMap = gson.fromJson(goodsString, HashMap.class);
                HashMap<Good, Integer> goods = Order.getGoodsMap(cartMap);
                double price = orderResultSet.getDouble("price");
                String status = orderResultSet.getString("status");

                return Optional.of(new Order(orderId, userId, goods, price, status));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getOrderQuery", e);
        }
        return Optional.empty();
    }

    public ArrayList<Order> getAllOrdersByUserId(long userId) {
        ArrayList<Order> result = new ArrayList<>();
        String getAllOrdersQuery = "SELECT * FROM orders WHERE user_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getAllOrdersQuery);
            preparedStatement.setLong(1, userId);
            ResultSet ordersResultSet = preparedStatement.executeQuery();
            while (ordersResultSet.next()) {
                long orderId = ordersResultSet.getLong("order_id");
                String goodsString = ordersResultSet.getString("goods");
                Gson gson = new Gson();
                HashMap<String, String> cartMap = gson.fromJson(goodsString, HashMap.class);
                HashMap<Good, Integer> goods = Order.getGoodsMap(cartMap);
                double price = ordersResultSet.getDouble("price");
                String status = ordersResultSet.getString("status");
                result.add(new Order(orderId, userId, goods, price, status));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getAllOrdersQuery", e);
        }
        return result;
    }

    public void deleteOrder(long orderId) {
        String deleteOrderQuery = "DELETE FROM orders WHERE order_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(deleteOrderQuery);
            preparedStatement.setLong(1, orderId);
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in deleteOrderQuery", e);
        }
    }

    public void updateStatus(long orderId, String status) {
        String updateOrderStatusQuery = "UPDATE orders SET status = ? WHERE order_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(updateOrderStatusQuery);
            preparedStatement.setString(1, status);
            preparedStatement.setLong(2, orderId);
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in updateOrderQuery", e);
        }
    }
}
