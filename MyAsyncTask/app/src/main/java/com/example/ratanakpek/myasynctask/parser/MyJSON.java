package com.example.ratanakpek.myasynctask.parser;

import com.example.ratanakpek.myasynctask.Banners;
import com.example.ratanakpek.myasynctask.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RatanakPek on 11/19/2016.
 */

public class MyJSON {

    public static List<Flower> parseFeed(String uri){
        try{
            JSONArray arr = new JSONArray(uri);
            List<Flower> flow = new ArrayList<>();

            for (int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);
                Flower flower = new Flower();
                flower.setProductid(obj.getInt("productId"));
                flower.setName(obj.getString("name"));
                flower.setCategory(obj.getString("category"));
                flower.setInstructtions(obj.getString("instructions"));
                flower.setPhoto(obj.getString("photo"));
                flower.setPrice(obj.getDouble("price"));
                flow.add(flower);
            }
            return flow;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Banners> myParseFeed(String uri){
        try{
            JSONArray arr = new JSONArray(uri);
            List<Banners> flow = new ArrayList<>();

            for (int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);

                Banners banners = new Banners();
                banners.setB_id(obj.getInt("CODE"));
                banners.setTitle(obj.getString("STATUS"));
             //   banners.setImage(obj.getString("image"));
             //   banners.setDescription(obj.getString("description"));

                flow.add(banners);
            }
            return flow;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
