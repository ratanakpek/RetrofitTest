package com.example.ratanakpek.volleytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ratanakpek.volleytest.recyclervs.GetDataRecycler;
import com.example.ratanakpek.volleytest.vol.MySingleTon;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    TextView tv;
    private static String url="http://androidtutorialpoint.com/api/volleyString";
    private static String imageurl ="http://androidtutorialpoint.com/api/apple_iphone6s";
    private static String json ="http://androidtutorialpoint.com/api/MobileJSONObject.json";
    private static String jsonarry="http://androidtutorialpoint.com/api/MobileJSONArray.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tvShow);
        img= (ImageView) findViewById(R.id.img);


        Intent go = new Intent(this, GetDataRecycler.class);
        startActivity(go);
    }

    public void getData(View view) {
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv.setText(response);
                Toast.makeText(MainActivity.this, "Hello String", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("Error!");
                error.printStackTrace();
            }
        });

        ImageRequest imageRequest = new ImageRequest(imageurl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img.setImageBitmap(response);
                Toast.makeText(MainActivity.this, "Hello Image", Toast.LENGTH_SHORT).show();
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("Image Error");
                error.printStackTrace();
            }
        });


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tv.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, jsonarry, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            tv.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
            }
        });

        //MySingleTon.getmInstance(getApplicationContext()).addToRequestQue(jsonArrayRequest);
        //MySingleTon.getmInstance(getApplicationContext()).addToRequestQue(stringRequest);
       // MySingleTon.getmInstance(getApplicationContext()).addToRequestQue(imageRequest);
       // RequestQueue queue = Volley.newRequestQueue(this);
        //queue.add(stringreq);
    }
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringreq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                tv.setText(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tv.setText("Error!");
//                error.printStackTrace();
//
//            }
//        });
//    queue.add(stringreq);
//    }
}
