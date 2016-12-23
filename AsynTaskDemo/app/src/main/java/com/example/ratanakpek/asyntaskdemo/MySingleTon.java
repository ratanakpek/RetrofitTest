package com.example.ratanakpek.asyntaskdemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * Created by RatanakPek on 11/21/2016.
 */

public class MySingleTon {
    private static  Context mContext;
    private static MySingleTon mInstance;
    private RequestQueue requestQueue;

    public MySingleTon(Context mContext) {
        this.mContext = mContext;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }


    public static synchronized MySingleTon getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleTon(context);
        }
        return mInstance;
    }

    public <T> void addToQueue(Request<T> request){
        requestQueue.add(request);
    }

}
