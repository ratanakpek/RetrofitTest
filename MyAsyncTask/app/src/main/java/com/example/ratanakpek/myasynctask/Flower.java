package com.example.ratanakpek.myasynctask;

import android.graphics.Bitmap;

/**
 * Created by RatanakPek on 11/19/2016.
 */

public class Flower {
    private int productid;
    private String name;
    private String category;
    private String instructtions;
    private double price;
    private String photo;
    private Bitmap bitmap;


    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructtions() {
        return instructtions;
    }

    public void setInstructtions(String instructtions) {
        this.instructtions = instructtions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
