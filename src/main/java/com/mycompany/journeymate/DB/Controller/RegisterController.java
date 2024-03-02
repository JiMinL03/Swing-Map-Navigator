package com.mycompany.journeymate.DB.Controller;

import com.mycompany.journeymate.DB.Respository.UserRespository;
import com.mycompany.journeymate.DB.DTO.UserDTO;
import com.mycompany.journeymate.DB.Respository.Connect;
import java.sql.Connection;
import java.util.ArrayList;

public class RegisterController { //사용자의 요청을 처리하고 응답을 생성하는 역할. Service에 전달

    private String message;
    private boolean overlapId;

    private Connect connect;
    private Connection connection;

    public RegisterController(ArrayList<String> data) { //registerGUI에서 받은 데이터들을 넘겨온다.

        UserDTO userDTO = new UserDTO(data);

        UserRespository respository = new UserRespository(userDTO);

        connect = Connect.getInstance();
        connection = connect.getConnection();

        if (connect != null) {
            respository.createUserTable();
            message = respository.inputRegisterData();
            overlapId = respository.checkOverlapId();
        }
    }

    public String toMessage() {
        return message;
    }
}
