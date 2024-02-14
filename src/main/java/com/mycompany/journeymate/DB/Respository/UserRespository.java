package com.mycompany.journeymate.DB.Respository;

import com.mycompany.journeymate.DB.Service.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRespository { //데이터 액세스 로직을 캡슐화, 직접적인 데이터 접근

    private UserService userRepository;

    public UserRespository(UserService userRepository) {
        this.userRepository = userRepository;
    }

    public UserRespository() {

    }
    String url = "jdbc:mariadb://localhost:3306/JourneyMate";
    String user = "root";
    String password = "JiMinL";
    private Connection connection;

    public void connect() { //DB 연결
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUserTable() {//user 테이블 생성
        String createTableQuery = "CREATE TABLE IF NOT EXISTS user (id VARCHAR(255), name TEXT, mail TEXT, password TEXT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
