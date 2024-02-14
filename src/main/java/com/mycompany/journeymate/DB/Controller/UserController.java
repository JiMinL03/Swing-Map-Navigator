package com.mycompany.journeymate.DB.Controller;
import com.mycompany.journeymate.DB.Respository.UserRespository;
import com.mycompany.journeymate.DB.UserDTO.UserDTO;
import java.util.ArrayList;

public class UserController { //사용자의 요청을 처리하고 응답을 생성하는 역할. Service에 전달

    public UserController(ArrayList<String> data) { //registerGUI에서 받은 데이터들을 넘겨온다.

        UserDTO userDTO = new UserDTO(data);

        UserRespository respository = new UserRespository(userDTO);
        respository.connect();
        respository.createUserTable();
        respository.inputRegisterData();
        respository.closeConnection();
    }
}
