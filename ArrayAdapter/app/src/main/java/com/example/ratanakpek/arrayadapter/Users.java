package com.example.ratanakpek.arrayadapter;

/**
 * Created by RatanakPek on 11/5/2016.
 */

public class Users {
    private String id;
    private String username;
    private String sex;

    public Users(String id, String username, String sex) {
        this.id = id;
        this.username = username;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
