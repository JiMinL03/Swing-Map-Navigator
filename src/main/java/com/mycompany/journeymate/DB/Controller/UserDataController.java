package com.mycompany.journeymate.DB.Controller;

import com.mycompany.journeymate.DB.DTO.UserDataDTO;
import com.mycompany.journeymate.DB.Respository.UserDataRespository;
import com.mycompany.journeymate.DB.Respository.Connect;
import java.sql.Connection;
import java.util.ArrayList;

public class UserDataController {

    private Connect connect;
    private Connection connection;
    private UserDataRespository respository;
    private boolean checkOverlapTitle;
    public UserDataController(String id, String Title, ArrayList<ArrayList<String>> returnArraylist) {
        UserDataDTO dto = new UserDataDTO(id, Title, returnArraylist);
        respository = new UserDataRespository(dto);

        connect = Connect.getInstance();
        connection = connect.getConnection();

        if (connect != null) {
            respository.createUserTable();
            checkOverlapTitle = respository.checkOverlapTitle();
            respository.inputUserData();
        }
        
    }
    public boolean toMessage() {
        System.out.println(respository.checkOverlapTitle());
        return checkOverlapTitle;
    }
}
