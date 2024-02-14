package com.mycompany.journeymate.DB.Controller;

import com.mycompany.journeymate.DB.Respository.UserRespository;
import java.util.ArrayList;

public class UserController { //사용자의 요청을 처리하고 응답을 생성하는 역할. Service에 전달
    
    private ArrayList<String> dataToSend;
    private String id;
    private String pw;
    private String mail;
    private String name;
    
    public UserController(ArrayList<String> data) { //registerGUI에서 받은 데이터들을 넘겨온다.
        this.dataToSend = data;
        this.id = dataToSend.get(0);
        this.pw = dataToSend.get(1);
        this.mail = dataToSend.get(2);
        this.name = dataToSend.get(3);
        
        UserRespository respository = new UserRespository(this);
        respository.connect();
        respository.createUserTable();
        respository.inputRegisterData();
        respository.closeConnection();
    }

    public ArrayList<String> getDataToSend() {
        return dataToSend;
    }

    public void setDataToSend(ArrayList<String> dataToSend) {
        this.dataToSend = dataToSend;
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
