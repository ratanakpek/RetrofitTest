package com.example.ratanakpek.myasynctask;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by RatanakPek on 11/18/2016.
 */

public class HttpManager {
    public static String getData(String url){

        BufferedReader reader=null;
        try {
            URL myurl = new URL(url);
            HttpURLConnection httpurl = (HttpURLConnection) myurl.openConnection();

            StringBuilder str = new StringBuilder();
            reader=new BufferedReader(new InputStreamReader(httpurl.getInputStream()));

            String line;
            while((line=reader.readLine())!=null){
                    str.append(line + " \n");
            }

            return str.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "";
    }

    public static String getData(String url, String username, String password){

        BufferedReader reader=null;

        byte[] loginBytes=(username+":"+password).getBytes();
        StringBuilder builder = new StringBuilder()
            .append("Basic ")
            .append(Base64.encodeToString(loginBytes , Base64.DEFAULT));

        try {
            URL myurl = new URL(url);
            HttpURLConnection httpurl = (HttpURLConnection) myurl.openConnection();

            httpurl.addRequestProperty("Authorization", builder.toString());



            StringBuilder str = new StringBuilder();
            reader=new BufferedReader(new InputStreamReader(httpurl.getInputStream()));

            String line;
            while((line=reader.readLine())!=null){
                str.append(line + "");
            }

            return str.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "errr";
    }
}
