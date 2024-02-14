package com.mycompany.journeymate.DB.UserDTO;
import java.util.ArrayList;

public class UserDTO {
    private String id;
    private String pw;
    private String mail;
    private String name;
    
    public UserDTO(ArrayList<String> data){
        this.id = data.get(0);
        this.pw = data.get(1);
        this.mail = data.get(2);
        this.name = data.get(3);
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
