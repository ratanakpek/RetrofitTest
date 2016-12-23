package com.example.ratanakpek.volleytest.vol;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.ratanakpek.volleytest.mContext.MyApplication;

/**
 * Created by RatanakPek on 11/20/2016.
 */

public class MySingleTon {
    private static MySingleTon mInstance;
    private RequestQueue requestQueue;

    public MySingleTon() {
        this.requestQueue = Volley.newRequestQueue(MyApplication.getContext());
    }

    public static MySingleTon getInstance(){
        if(mInstance==null){
            mInstance= new MySingleTon();
        }
        return mInstance;
    }
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

//Make sure the the request stay long as life time of our app
//    public RequestQueue getRequestQueue(){
//        if(requestQueue==null){
//            requestQueue= Volley.newRequestQueue(mContext.getApplicationContext());
//        }
//        return requestQueue;
//    }
//    public MySingleTon(Context context) {
//        this.mContext = context;
//        requestQueue=getRequestQueue();
//    }
//    public  static synchronized MySingleTon getmInstance(Context context){
//        if(mInstance==null){
//            mInstance=new MySingleTon(context);
//        }
//        return mInstance;
//    }
//    public <T> void addToRequestQue(Request<T> req){
//        requestQueue.add(req);
//    }
}
