package com.example.ratanakpek.volleytest.mContext;

import android.app.Application;
import android.content.Context;

/**
 * Created by RatanakPek on 11/22/2016.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static MyApplication getInstance(){
    return mInstance;
    }

    public static Context getContext(){
        return mInstance.getApplicationContext();
    }
}
