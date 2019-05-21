package com.shop.dao.implamentation.jdbc;

import com.shop.dao.ConnectionUtil;
import com.shop.dao.GoodDao;
import com.shop.model.Good;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//public class GoodDaoImpl implements GoodDao {
//
//    private static final Logger logger = Logger.getLogger(GoodDao.class);
//    private static final Connection CONNECTION = ConnectionUtil.connect();
//
//    @Override
//    public long addGood(Good good) {
//        String addGoodQuery = "INSERT INTO goods(good_name, description, price) VALUES(?, ?, ?);";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addGoodQuery, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, good.getName());
//            preparedStatement.setString(2, good.getDescription());
//            preparedStatement.setDouble(3, good.getPrice());
//            preparedStatement.executeUpdate();
//            logger.debug("Executed query: " + preparedStatement.toString());
//            ResultSet key = preparedStatement.getGeneratedKeys();
//            if (key.next()) {
//                return key.getLong(1);
//            }
//        } catch (SQLException e) {
//            logger.error("SQL error in addGoodQuery", e);
//        }
//        return -1;
//    }
//
//    @Override
//    public Optional<Good> getGoodById(long goodId) {
//        String getGoodByIdQuery = "SELECT * FROM goods WHERE good_id = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getGoodByIdQuery);
//            preparedStatement.setLong(1, goodId);
//            ResultSet goodResultSet = preparedStatement.executeQuery();
//            logger.debug("Executed query: " + preparedStatement.toString());
//            if (goodResultSet.next()) {
//                String name = goodResultSet.getString("good_name");
//                String description = goodResultSet.getString("description");
//                double price = goodResultSet.getDouble("price");
//
//                return Optional.of(new Good(goodId, name, description, price));
//            }
//        } catch (SQLException e) {
//            logger.error("SQL error in getGoodQuery", e);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Good> getAllGoods() {
//        List<Good> result = new ArrayList<>();
//        String getGoodByIdQuery = "SELECT * FROM goods";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getGoodByIdQuery);
//            logger.debug("Executed query: " + preparedStatement.toString());
//            ResultSet goodResultSet = preparedStatement.executeQuery();
//            while (goodResultSet.next()) {
//                Long id = goodResultSet.getLong("good_id");
//                String name = goodResultSet.getString("good_name");
//                String description = goodResultSet.getString("description");
//                double price = goodResultSet.getDouble("price");
//
//                result.add(new Good(id, name, description, price));
//            }
//        } catch (SQLException e) {
//            logger.error("SQL error in addAllGoodsQuery", e);
//        }
//        return result;
//    }
//
//    @Override
//    public int deleteGoodById(long goodId) {
//        int result = 0;
//        String removeGoodByIdQuery = "DELETE FROM goods WHERE good_id = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(removeGoodByIdQuery);
//            preparedStatement.setLong(1, goodId);
//            result = preparedStatement.executeUpdate();
//            logger.debug("Executed query: " + preparedStatement.toString());
//        } catch (SQLException e) {
//            logger.error("SQL error in removeGoodQuery", e);
//        }
//        return result;
//    }
//
//    @Override
//    public int updateGoodById(long goodId, Good good) {
//        int result = 0;
//        String updateGoodByIdQuery = "UPDATE goods SET good_name = ?, description = ?, price = ? WHERE good_id = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(updateGoodByIdQuery);
//            preparedStatement.setString(1, good.getName());
//            preparedStatement.setString(2, good.getDescription());
//            preparedStatement.setDouble(3, good.getPrice());
//            preparedStatement.setLong(4, good.getGoodId());
//            result = preparedStatement.executeUpdate();
//            logger.debug("Executed query: " + preparedStatement.toString());
//        } catch (SQLException e) {
//            logger.error("SQL error in updateGoodQuery", e);
//        }
//        return result;
//    }
//}
