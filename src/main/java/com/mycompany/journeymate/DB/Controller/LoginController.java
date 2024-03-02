package com.mycompany.journeymate.DB.Controller;

import com.mycompany.journeymate.DB.DTO.UserDTO;
import com.mycompany.journeymate.DB.Respository.Connect;
import com.mycompany.journeymate.DB.Respository.UserRespository;
import java.sql.Connection;
import java.util.ArrayList;

public class LoginController {

    private Connect connect;
    private Connection connection;

    private UserRespository respository;
    boolean resultMessage;

    public LoginController(ArrayList<String> data) { //registerGUI에서 받은 데이터들을 넘겨온다.
        UserDTO userDTO = new UserDTO(data);
        respository = new UserRespository(userDTO);

        connect = Connect.getInstance();
        connection = connect.getConnection();

        respository.createUserTable();
        resultMessage = respository.checkLogin();

        if (connect != null) {
            respository.createUserTable();
            resultMessage = respository.checkLogin();
        }
    }

    public String toMessage() {
        if (resultMessage) {
            return "다시 만나서 반가워요!";
        } else {
            return "로그인 정보가 알맞지 않습니다.";
        }
    }
}
