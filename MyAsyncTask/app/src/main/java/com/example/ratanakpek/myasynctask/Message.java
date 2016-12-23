package com.example.ratanakpek.myasynctask;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by RatanakPek on 11/18/2016.
 */

public class Message {
    public static void message(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
