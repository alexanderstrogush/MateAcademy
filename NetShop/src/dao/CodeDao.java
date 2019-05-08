package dao;

import model.Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.log4j.Logger;

public class CodeDao {

    private static final Logger logger = Logger.getLogger(CodeDao.class);
    private static final Connection CONNECTION = ConnectionUtil.connect();

    public void addCode(Code code) {
        String addCodeQuery = "INSERT INTO codes(user_id, order_id, value) VALUES(?, ?, ?);";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addCodeQuery);
            preparedStatement.setLong(1, code.getUserId());
            preparedStatement.setLong(2, code.getOrderId());
            preparedStatement.setString(3, code.getValue());
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in addCodeQuery", e);
        }
    }

    public Optional<Code> getCodeByUse(long userId, String values) {
        String getCodeQuery = "SELECT * FROM codes WHERE user_id = ? AND value = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getCodeQuery);
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, values);
            ResultSet codeResultSet = preparedStatement.executeQuery();
            logger.debug("Executed query: " + preparedStatement.toString());
            if (codeResultSet.next()) {
                long codeId = codeResultSet.getLong("code_id");
                long orderId = codeResultSet.getLong("order_id");
                return Optional.of(new Code(codeId, userId, orderId, values));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getCodeQuery", e);
        }
        return Optional.empty();
    }

    public void deleteCodeById(long codeId) {
        String deleteCodeQuery = "DELETE FROM codes WHERE code_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(deleteCodeQuery);
            preparedStatement.setLong(1, codeId);
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in deleteCodeQuery", e);
        }
    }
}
