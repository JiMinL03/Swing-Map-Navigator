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
    public void UserDataRespository() {
        createUserTable();
        inputUserData();
    }

    private void createUserTable() {//로그인 id를 키값으로 연장선 테이블 생성
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + userDataDTO.getId() + " (user_id VARCHAR(255), FOREIGN KEY (user_id) REFERENCES user(id), title TEXT, location TEXT, memo TEXT, start_time TEXT, end_time TEXT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("createUserTable error" + e);
            e.printStackTrace();
        }
    }

    private void inputUserData() {//회원가입 정보 DB에 입력
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
            System.out.println("inputUseData success");
        } catch (SQLException e) {
            System.out.println("inputRegisterData error");
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return titleList;
    }
}
