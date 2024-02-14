package com.mycompany.journeymate.DB.Respository;

import com.mycompany.journeymate.DB.Service.UserService;
import java.util.ArrayList;

public class UserRespository extends UserService { //데이터 액세스 로직을 캡슐화, 직접적인 데이터 접근

    public UserRespository(ArrayList<String> data) {
        super(data);
    }
}
