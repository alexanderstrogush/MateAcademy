package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final Logger logger = Logger.getLogger(ConnectionUtil.class);

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/madb" +
            "?verifyServerCertificate=false" +
            "&useUnicode=true" +
            "&characterEncoding=utf-8" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "g2025hda";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("MySql driver wasn't finding", e);
        }
    }

    public static Connection connect() {
        return connection;
    }
}
