package src.main.java.com.keysoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    static Connection connection = null;

    public static Connection getConnection() {
        if (connection!=null)
            return connection;

        return getNewConnection();
    }

    private static Connection getNewConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tat_schema?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
            		                      "tatuser","fireFISH_1");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return connection;
    }
}
