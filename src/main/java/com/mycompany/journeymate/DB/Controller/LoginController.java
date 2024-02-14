package com.mycompany.journeymate.DB.Controller;

import com.mycompany.journeymate.DB.DTO.UserDTO;
import com.mycompany.journeymate.DB.Respository.UserRespository;
import java.util.ArrayList;

public class LoginController {

    private UserRespository respository;
    boolean resultMessage;

    public LoginController(ArrayList<String> data) { //registerGUI에서 받은 데이터들을 넘겨온다.
        UserDTO userDTO = new UserDTO(data);
        respository = new UserRespository(userDTO);
        respository.connect();
        respository.createUserTable();
        resultMessage = respository.checkLogin();
        respository.closeConnection();
    }

    public String toMessage() {
        if (resultMessage) {
            return "다시 만나서 반가워요!";
        } else {
            return "로그인 정보가 알맞지 않습니다.";
        }
    }
}
