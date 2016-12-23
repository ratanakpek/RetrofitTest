package com.example.ratanakpek.myasynctask.postget;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ratanakpek.myasynctask.Flower;
import com.example.ratanakpek.myasynctask.R;
import com.example.ratanakpek.myasynctask.parser.MyJSON;

import java.util.List;

/**
 * Created by RatanakPek on 11/19/2016.
 */

public class ActivityClass extends Activity {
    TextView tvShow;
    ProgressBar progress;

    List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postget);

        tvShow= (TextView) findViewById(R.id.ptv);
        progress= (ProgressBar) findViewById(R.id.pProgress);
        tvShow.setMovementMethod(new ScrollingMovementMethod());


    }

    public void showData(){
        for (Flower f:flowerList) {
            tvShow.append(f.getName()+"\n");
        }
    }

    public void onClickMe(View view) {
        MyAsynT task = new MyAsynT();
        task.execute("http://services.hanselandpetal.com/feeds/flowers.json");

    }

    class MyAsynT extends AsyncTask<String, String, List<Flower>>{
        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Flower> doInBackground(String... strings) {
            String content = MyHttp.getData(strings[0]);
            flowerList= MyJSON.parseFeed(content);
            return flowerList;
        }

        @Override
        protected void onPostExecute(List<Flower> flowers) {
            progress.setVisibility(View.INVISIBLE);
            showData();
        }
    }
}
