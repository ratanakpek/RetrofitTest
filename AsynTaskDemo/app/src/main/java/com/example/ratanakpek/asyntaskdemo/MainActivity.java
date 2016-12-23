package com.example.ratanakpek.asyntaskdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView img;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img= (TextView) findViewById(R.id.text);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        Intent go = new Intent(this, VolleyTest.class);
        startActivity(go);
    }

    public void action(View view) {
        new CustomAsynTask().execute("http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo", "Ratanak");
    }

    class CustomAsynTask extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... param) {
            BufferedReader reader = null;
            try {
                URL url = new URL(param[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));


                StringBuilder bs = new StringBuilder();
                String str;
                while((str=reader.readLine()) != null){
                        bs.append(str+"\n");
                }

                    return bs.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {

                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String bitmap) {
            progressBar.setVisibility(View.GONE);
            img.setText(bitmap);

        }
    }
}
