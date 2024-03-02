package com.mycompany.journeymate.DB.Respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {//싱글턴패턴 사용

    String url = "jdbc:mariadb://localhost:3306/JourneyMate";
    String user = "root";
    String password = "JiMinL";

    private static Connect connect;
    private Connection connection;

    public Connect() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("connect error");
        }
    }

    public static synchronized Connect getInstance() {
        if (connect == null) {
            connect = new Connect();
        }
        return connect;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() { //DB 연결 종료
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
