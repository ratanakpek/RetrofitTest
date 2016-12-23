package com.example.ratanakpek.myasynctask;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratanakpek.myasynctask.parser.ClassSync;
import com.example.ratanakpek.myasynctask.parser.MyJSON;
import com.example.ratanakpek.myasynctask.postget.ActivityClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listv;
    ProgressBar bar;
    List<MyAsyncTask> task;
    List<Flower> flowerlist;
    List<Banners> bannerslist;
    public static final String PHOTO="http://services.hanselandpetal.com/photos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent go = new Intent(this, ClassSync.class);
        startActivity(go);


        listv = (ListView) findViewById(R.id.listviewapi);


        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setVisibility(View.INVISIBLE);

        task = new ArrayList<>();

    }

    public void updateDisplay() {

        FlowerAdapter adapter=new FlowerAdapter(this, R.layout.item_display, flowerlist);
        listv.setAdapter(adapter);


//        if (flowerlist != null) {
//            for (Flower flower : flowerlist) {
//                tv.append(flower.getName() + "\n");
//            }
//        }
    }

    public void onClick(View view) {
        if (isOnline()) {
            requestData("http://services.hanselandpetal.com/feeds/flowers.json");
        } else {
            Toast.makeText(this, "Network unavailable!", Toast.LENGTH_SHORT).show();
        }

    }

    private void requestData(String url) {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(url);
    }

    public boolean isOnline() {
        ConnectivityManager manageer = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manageer.getActiveNetworkInfo();
        if (network != null && network.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    class MyAsyncTask extends AsyncTask<String, String, List<Flower>> {

        @Override
        protected void onPreExecute() {
            // super.onPreExecute();

            if (task.size() == 0) {
                bar.setVisibility(View.VISIBLE);
            }
            task.add(this);
        }

        @Override
        protected List<Flower> doInBackground(String... strings) {
//            for(int i=0;i<strings.length;i++){
//                publishProgress("Working with "+strings[i]);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
                 String content = HttpManager.getData(strings[0]);
                flowerlist=MyJSON.parseFeed(content);

//                for(Flower f :flowerlist){
//                    String imageurl = PHOTO+f.getPhoto();
//                    try {
//                        InputStream in = (InputStream) new URL(imageurl).getContent();
//                        Bitmap bit = BitmapFactory.decodeStream(in);
//                        f.setBitmap(bit);
//                        in.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
            return flowerlist;
        }

        @Override
        protected void onPostExecute(List<Flower> s) {
            task.remove(this);
            if (task.size() == 0) {
                bar.setVisibility(View.INVISIBLE);
            }
            updateDisplay();
            /*flowerlist = MyJSON.parseFeed(s);

            if (s == null) {
                Toast.makeText(MainActivity.this, "Can't not connect web service", Toast.LENGTH_SHORT).show();
            }*/

        }

        @Override
        protected void onProgressUpdate(String... values) {

        }
    }
}
