package com.example.ratanakpek.sqllitedemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by RatanakPek on 11/17/2016.
 */

public class Message {

    public static void message(Context context, String data){
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }


}
