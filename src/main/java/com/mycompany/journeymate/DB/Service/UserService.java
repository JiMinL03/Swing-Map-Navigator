package com.mycompany.journeymate.DB.Service;

import com.mycompany.journeymate.DB.Controller.UserController;
import com.mycompany.journeymate.DB.Respository.UserRespository;
import java.util.ArrayList;

public class UserService extends UserController { //비즈니스 로직을 처리하는 역할
    private String id;
    private String pw;
    private String mail;
    private String name;
    
    public UserService(ArrayList<String> data) {
        super(data);
        this.id = getId();
        this.pw = getPw();
        this.mail = getMail();
        this.name = getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
