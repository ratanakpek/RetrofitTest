package com.example.ratanakpek.volleytest.message;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by RatanakPek on 11/22/2016.
 */

public class Message {
    public static void msg(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
