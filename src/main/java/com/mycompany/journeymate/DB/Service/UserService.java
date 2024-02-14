package com.mycompany.journeymate.DB.Service;

import com.mycompany.journeymate.DB.Controller.UserController;
import java.util.ArrayList;

public class UserService extends UserController { //비즈니스 로직을 처리하는 역할
    public UserService(ArrayList<String> data) {
        super(data);
    }
}
