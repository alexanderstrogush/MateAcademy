package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/madb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        return connection;
    }
}
