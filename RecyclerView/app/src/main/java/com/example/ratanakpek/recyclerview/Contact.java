package com.example.ratanakpek.recyclerview;

import java.util.ArrayList;

/**
 * Created by RatanakPek on 11/6/2016.
 */

public class Contact {
    private String id;
    private String name;

    public Contact(String name, String id){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Contact> createObj(int quantity){
        ArrayList<Contact> obj = new ArrayList<>();
        for(int i=0;i<=quantity;i++){
            obj.add(new Contact("Mr. Nak "+quantity, "Lover : "+quantity+quantity));        }

    return obj;
    }
}

