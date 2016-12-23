package com.example.ratanakpek.arrayadapter;

/**
 * Created by RatanakPek on 11/5/2016.
 */

public class Hotel {
    private String image;
    private String title;
    private String desc;
    private String price;
    private int bed;
    private int bathroom;
    private int carspot;

    public Hotel(String price, String image, String title, String desc, int bed, int bathroom, int carspot) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.bed = bed;
        this.bathroom = bathroom;
        this.carspot = carspot;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getCarspot() {
        return carspot;
    }

    public void setCarspot(int carspot) {
        this.carspot = carspot;
    }
}
