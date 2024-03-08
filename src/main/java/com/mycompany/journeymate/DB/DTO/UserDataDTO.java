package com.mycompany.journeymate.DB.DTO;

import java.util.ArrayList;

public class UserDataDTO {

    private String id;
    private String Title;
    private ArrayList<String> location;
    private ArrayList<String> memo;
    private ArrayList<String> startTime;
    private ArrayList<String> endTime;

    public UserDataDTO(String id, String Title, ArrayList<ArrayList<String>> returnArraylist) {
        this.id = id;
        this.Title = Title;
        this.location = returnArraylist.get(0);
        this.memo = returnArraylist.get(1);
        this.startTime = returnArraylist.get(2);
        this.endTime = returnArraylist.get(3);
    }

    public UserDataDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public ArrayList<String> getMemo() {
        return memo;
    }

    public void setMemo(ArrayList<String> memo) {
        this.memo = memo;
    }

    public ArrayList<String> getStartTime() {
        return startTime;
    }

    public void setStartTime(ArrayList<String> startTime) {
        this.startTime = startTime;
    }

    public ArrayList<String> getEndTime() {
        return endTime;
    }

    public void setEndTime(ArrayList<String> endTime) {
        this.endTime = endTime;
    }
}
