package com.example.ratanakpek.volleytest.recyclervs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.ratanakpek.volleytest.API.APIClass;
import com.example.ratanakpek.volleytest.JSONs.GsonObjectRequest;
import com.example.ratanakpek.volleytest.R;
import com.example.ratanakpek.volleytest.message.Message;
import com.example.ratanakpek.volleytest.vol.MySingleTon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RatanakPek on 11/20/2016.
 */

public class GetDataRecycler extends Activity {
    private ArrayList<Product> productList = new ArrayList<>();
    MyRecycler myRecycler;
    RecyclerView recyclerView;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.getdatarecycler);
        requestQueue= MySingleTon.getInstance().getRequestQueue();

        recyclerView = (RecyclerView) findViewById(R.id.recylcer);
        myRecycler = new MyRecycler(productList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myRecycler);
        Toast.makeText(GetDataRecycler.this, "Size : " + productList.toString() + "ddd", Toast.LENGTH_SHORT).show();
        Log.d("x", "oncreate");
    }

    public void onClick(View view){
        GsonObjectRequest gson = new GsonObjectRequest(Request.Method.GET, APIClass.url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Message.msg(GetDataRecycler.this, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.msg(GetDataRecycler.this, error.toString());
            }
        });

        requestQueue.add(gson);

    }

    public void postData(View view) {

       GsonObjectRequest gson = new GsonObjectRequest(Request.Method.POST, APIClass.posturl, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               Message.msg(GetDataRecycler.this, response.toString());
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Message.msg(GetDataRecycler.this, error.toString());
           }
       }){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String, String> jsonBody = new HashMap<String, String>();
               jsonBody.put("b_id", "33");
               jsonBody.put("description", "myid");
               jsonBody.put("end_date", "myid");
               jsonBody.put("image", "myid");
               jsonBody.put("order_id", "myid");
               jsonBody.put("start_date", "myid");
               jsonBody.put("title", "myid");
               jsonBody.put("url", "myid");
               return jsonBody;
           }
       };
        requestQueue.add(gson);
    }

    public void deleteData(View view) {
//        Map<String, String> param = new HashMap<>();
//        param.put("id", "2");
        final JSONObject obj = new JSONObject();
        try {
            obj.put("id", "2");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GsonObjectRequest delete  = new GsonObjectRequest(Request.Method.DELETE, APIClass.delete+"?id=3", obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Message.msg(GetDataRecycler.this, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.msg(GetDataRecycler.this, error.toString());
                error.printStackTrace();
            }
        });
//
        requestQueue.add(delete);

    }
    public void delete(){
        //Map<String, String> jsonBody = new HashMap<String, String>();

        JSONObject jsonBody= new JSONObject();
        try {
            jsonBody.put("TITLE", "TEst");
            jsonBody.put("AUTHOR", 2);
            jsonBody.put("CATEGORY_ID", 4);
            jsonBody.put("STATUS", "TEst");
            jsonBody.put("IMAGE", "TEst");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        GsonObjectRequest gson = new GsonObjectRequest(Request.Method.PUT, APIClass.update, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Message.msg(GetDataRecycler.this, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.msg(GetDataRecycler.this, error.toString());
            }
        });

        requestQueue.add(gson);
    }

    public void updateData(View view) {
        delete();
    }
}
