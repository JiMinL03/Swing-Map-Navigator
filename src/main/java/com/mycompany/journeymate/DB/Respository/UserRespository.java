package com.mycompany.journeymate.DB.Respository;

import com.mycompany.journeymate.DB.DTO.UserDTO;
import java.sql.Connection;
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

    private Connect connect;
    private Connection connection;

    public UserRespository(UserDTO userDTO) {
        this.userDTO = userDTO;

        this.id = userDTO.getId();
        this.pw = userDTO.getPw();
        this.mail = userDTO.getMail();
        this.name = userDTO.getName();

        connect = Connect.getInstance();
        connection = connect.getConnection();
    }
    public void createUserTable() {//user 테이블 생성
        String createTableQuery = "CREATE TABLE IF NOT EXISTS user (id VARCHAR(255) PRIMARY KEY, name TEXT, mail TEXT, password TEXT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("createUserTable error");
        }
    }
    public boolean checkOverlapId() {//중복된 아이디 확인
        String checkOverlapId = "SELECT id FROM user WHERE id = '" + id + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(checkOverlapId);
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("checkOverlapId error");
            return false;
        }
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

    public boolean checkLogin() {//아이디 비번 확인
        String checkLogin = "SELECT id, password FROM user WHERE id = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(checkLogin)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            // executeQuery를 사용하여 결과 집합을 가져옵니다.
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // 로그인 성공
                    System.out.println("Login successful");
                    return true;
                } else {
                    // 로그인 실패
                    System.out.println("Login unsuccessful");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login Error");
        }
        return true;
    }
}
