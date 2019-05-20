//package com.shop.dao.implamentation.jdbc;
//
//import com.shop.dao.ConnectionUtil;
//import com.shop.dao.CodeDao;
//import com.shop.model.Code;
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Optional;
//
//public class CodeDaoImpl implements CodeDao {
//
//    private static final Logger logger = Logger.getLogger(CodeDao.class);
//    private static final Connection CONNECTION = ConnectionUtil.connect();
//
//    @Override
//    public long addCode(Code code) {
//        String addCodeQuery = "INSERT INTO codes(user_id, order_id, value) VALUES(?, ?, ?);";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addCodeQuery, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setLong(1, code.getUserId());
//            preparedStatement.setLong(2, code.getOrderId());
//            preparedStatement.setString(3, code.getValue());
//            preparedStatement.executeUpdate();
//            logger.debug("Executed query: " + preparedStatement.toString());
//            ResultSet idSet = preparedStatement.getGeneratedKeys();
//            if (idSet.next()) {
//                return idSet.getLong(1);
//            }
//        } catch (SQLException e) {
//            logger.error("SQL error in addCodeQuery", e);
//        }
//        return -1;
//    }
//
//    @Override
//    public Optional<Code> getCodeByValue(long userId, String values) {
//        String getCodeQuery = "SELECT * FROM codes WHERE user_id = ? AND value = ?;";
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getCodeQuery);
//            preparedStatement.setLong(1, userId);
//            preparedStatement.setString(2, values);
//            ResultSet codeResultSet = preparedStatement.executeQuery();
//            logger.debug("Executed query: " + preparedStatement.toString());
//            if (codeResultSet.next()) {
//                long codeId = codeResultSet.getLong("code_id");
//                long orderId = codeResultSet.getLong("order_id");
//                return Optional.of(new Code(codeId, userId, orderId, values));
//            }
//        } catch (SQLException e) {
//            logger.error("SQL error in getCodeQuery", e);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public int deleteCodeById(long codeId) {
//        String deleteCodeQuery = "DELETE FROM codes WHERE code_id = ?;";
//        int result = 0;
//        try {
//            PreparedStatement preparedStatement = CONNECTION.prepareStatement(deleteCodeQuery);
//            preparedStatement.setLong(1, codeId);
//            result = preparedStatement.executeUpdate();
//            logger.debug("Executed query: " + preparedStatement.toString());
//        } catch (SQLException e) {
//            logger.error("SQL error in deleteCodeQuery", e);
//        }
//        return result;
//    }
//}
