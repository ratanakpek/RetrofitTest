package com.example.advancecourse.homework;

/**
 * Created by RatanakPek on 11/11/2016.
 */

public class Products {
    private String title;
    private String views;
    private String date;
    private String desc;
    private String image;

    public Products(String title, String views, String date, String desc, String image) {
        this.title = title;
        this.views = views;
        this.date = date;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
