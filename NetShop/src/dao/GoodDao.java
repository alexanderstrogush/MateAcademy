package dao;

import model.Good;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class GoodDao {

    private static final Logger logger = Logger.getLogger(GoodDao.class);
    private static final Connection CONNECTION = ConnectionUtil.connect();

    public void addGood(Good good) {
        String addGoodQuery = "INSERT INTO goods(good_name, description, price) VALUES(?, ?, ?);";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(addGoodQuery);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setString(2, good.getDescription());
            preparedStatement.setDouble(3, good.getPrice());
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in addGoodQuery", e);
        }
    }

    public Optional<Good> getGoodById(long id) {
        String getGoodByIdQuery = "SELECT * FROM goods WHERE good_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getGoodByIdQuery);
            preparedStatement.setLong(1, id);
            ResultSet goodResultSet = preparedStatement.executeQuery();
            logger.debug("Executed query: " + preparedStatement.toString());
            if (goodResultSet.next()) {
                String name = goodResultSet.getString("good_name");
                String description = goodResultSet.getString("description");
                double price = goodResultSet.getDouble("price");

                return Optional.of(new Good(id, name, description, price));
            }
        } catch (SQLException e) {
            logger.error("SQL error in getGoodQuery", e);
        }
        return Optional.empty();
    }

    public ArrayList<Good> getAllGoods() {
        ArrayList<Good> result = new ArrayList<>();
        String getGoodByIdQuery = "SELECT * FROM goods";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(getGoodByIdQuery);
            logger.debug("Executed query: " + preparedStatement.toString());
            ResultSet goodResultSet = preparedStatement.executeQuery();
            while (goodResultSet.next()) {
                Long id = goodResultSet.getLong("good_id");
                String name = goodResultSet.getString("good_name");
                String description = goodResultSet.getString("description");
                double price = goodResultSet.getDouble("price");

                result.add(new Good(id, name, description, price));
            }
        } catch (SQLException e) {
            logger.error("SQL error in addAllGoodsQuery", e);
        }
        return result;
    }

    public void removeGoodById(long id) {
        String removeGoodByIdQuery = "DELETE FROM goods WHERE good_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(removeGoodByIdQuery);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in removeGoodQuery", e);
        }
    }

    public void updateGoodById(Good good) {
        String updateGoodByIdQuery = "UPDATE goods SET good_name = ?, description = ?, price = ? WHERE good_id = ?;";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(updateGoodByIdQuery);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setString(2, good.getDescription());
            preparedStatement.setDouble(3, good.getPrice());
            preparedStatement.setLong(4, good.getGoodId());
            preparedStatement.executeUpdate();
            logger.debug("Executed query: " + preparedStatement.toString());
        } catch (SQLException e) {
            logger.error("SQL error in updateGoodQuery", e);
        }
    }
}
