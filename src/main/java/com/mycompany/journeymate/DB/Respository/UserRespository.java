package com.mycompany.journeymate.DB.Respository;

import com.mycompany.journeymate.DB.UserDTO.UserDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRespository { //데이터 액세스 로직을 캡슐화, 직접적인 데이터 접근
    private UserDTO userDTO;
    private String id;
    private String pw;
    private String mail;
    private String name;
    
    public UserRespository(UserDTO userDTO) {
        this.userDTO = userDTO;

        this.id = userDTO.getId();
        this.pw = userDTO.getPw();
        this.mail = userDTO.getMail();
        this.name = userDTO.getName();
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
            System.out.println("connect error");
        }
    }

    public void createUserTable() {//user 테이블 생성
        String createTableQuery = "CREATE TABLE IF NOT EXISTS user (id VARCHAR(255), name TEXT, mail TEXT, password TEXT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("createUserTable error");
        }
    }

    private boolean checkOverlapId() {//중복된 아이디 확인
        String checkOverlapId = "SELECT id FROM user WHERE id = '" + id + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(checkOverlapId);
            //Statement 객체의 executeQuery 메서드를 사용하여 SQL 쿼리(checkOverlapId)를 실행하고, 그 결과를 ResultSet으로 반환
            if (resultSet.next()) {
                // If there is a result in the ResultSet, it means the ID already exists
                return true;
            } else {
                // If no result, the ID doesn't exist
                return false;
            }
        } catch (SQLException e) {
            System.out.println("checkOverlapId error");
        }
        return true;
    }

    public String inputRegisterData() {//회원가입 정보 DB에 입력
        String inputRegisterData = "INSERT INTO user (id, name, mail, password) VALUES (?, ?, ?, ?)";
        if (!checkOverlapId()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(inputRegisterData)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, mail);
                preparedStatement.setString(4, pw);

                preparedStatement.executeUpdate();
                System.out.println("회원가입 정보 DB에 입력");
            } catch (SQLException e) {
                System.out.println("inputRegisterData error");
            }
            return "환영합니다. " + name + "님!";
        } else {
            return "이미 존재하는 아이디입니다.";
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
