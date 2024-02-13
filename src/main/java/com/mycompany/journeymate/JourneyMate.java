/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.journeymate;

import com.mycompany.journeymate.GUI.LoginGUI;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LG
 */
public class JourneyMate {

    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        gui.setVisible(true);
        
        String url = "jdbc:mariadb://localhost:3306/JourneyMate";
        String user = "root";
        String password = "JiMinL";

        // JDBC 드라이버 로딩
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 데이터베이스 연결
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // 테이블 생성 쿼리
            String createTableQuery = "CREATE TABLE IF NOT EXISTS user (id VARCHAR(255), name TEXT, mail TEXT, password TEXT)";
            
            // Statement를 사용하여 쿼리 실행
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableQuery);
            }
            
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
