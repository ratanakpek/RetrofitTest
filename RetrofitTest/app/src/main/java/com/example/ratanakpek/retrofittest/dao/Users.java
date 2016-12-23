package com.example.ratanakpek.retrofittest.dao;

/**
 * Created by RatanakPek on 11/22/2016.
 */

public class Users {
    private String CODE;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public User getDATA() {
        return DATA;
    }

    public void setDATA(User DATA) {
        this.DATA = DATA;
    }

    public Pagination getPage() {
        return page;
    }

    public void setPage(Pagination page) {
        this.page = page;
    }

    private String Message;
    private User DATA;
    private Pagination page;

}
