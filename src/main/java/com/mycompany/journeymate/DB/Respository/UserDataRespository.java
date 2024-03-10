package com.mycompany.journeymate.DB.Respository;

import com.mycompany.journeymate.DB.DTO.UserDataDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDataRespository {//데이터 액세스 로직을 캡슐화, 직접적인 데이터 접근

    private UserDataDTO userDataDTO;
    private Connect connect;
    private Connection connection;

    private String title;
    private ArrayList<String> location;
    private ArrayList<String> memo;
    private ArrayList<String> startTime;
    private ArrayList<String> endTime;

    public UserDataRespository(UserDataDTO userDataDTO) {
        this.userDataDTO = userDataDTO;
        this.title = userDataDTO.getTitle();
        this.location = userDataDTO.getLocation();
        this.memo = userDataDTO.getMemo();
        this.startTime = userDataDTO.getStartTime();
        this.endTime = userDataDTO.getEndTime();

        connect = Connect.getInstance();
        connection = connect.getConnection();
    }

    public void createUserTable() {//로그인 id를 키값으로 연장선 테이블 생성
        System.out.println(userDataDTO.getTitle());
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + userDataDTO.getId() + " (user_id VARCHAR(255), FOREIGN KEY (user_id) REFERENCES user(id), title TEXT, location TEXT, memo TEXT, start_time TEXT, end_time TEXT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
        } catch (SQLException e) {
            System.out.println("createUserTable error" + e);
        }
    }

    public boolean checkOverlapTitle() {
        String checkOverlapTitle = "SELECT title FROM " + userDataDTO.getId() + " WHERE title = '" + userDataDTO.getTitle() + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(checkOverlapTitle);
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("checkOverlapTitle error: " + e.getMessage());
            e.printStackTrace();
            return false; // 예외 발생 시 false를 반환하도록 처리
        }
    }

    public void inputUserData() {
        System.out.println(checkOverlapTitle());
        if (!checkOverlapTitle()) {
            String inputUserData = "INSERT INTO " + userDataDTO.getId() + " (title, location, memo, start_time, end_time, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(inputUserData)) {
                for (int i = 0; i < location.size(); i++) {
                    preparedStatement.setString(1, title);
                    preparedStatement.setString(2, location.get(i));
                    preparedStatement.setString(3, memo.get(i));
                    preparedStatement.setString(4, startTime.get(i));
                    preparedStatement.setString(5, endTime.get(i));
                    preparedStatement.setString(6, userDataDTO.getId());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("inputRegisterData error");
            }
        }
    }

    public ArrayList<String> returnTitle() {
        ArrayList<String> titleList = new ArrayList<>();
        String returnTitle = "SELECT title FROM " + userDataDTO.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(returnTitle)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                titleList.add(title);
            }
        } catch (SQLException e) {
            System.out.println("아이디 관련 데이터가 없습니다.");
        }
        return titleList;
    }
}
