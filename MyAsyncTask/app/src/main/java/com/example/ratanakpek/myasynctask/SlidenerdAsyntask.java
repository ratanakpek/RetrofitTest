package com.example.ratanakpek.myasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RatanakPek on 11/18/2016.
 */

public class SlidenerdAsyntask extends Activity {
    ListView listView;
    List<String> data=new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.slideasynctask);
        listView= (ListView) findViewById(R.id.listview);

        generate(20);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);


        new CustomAsyn().execute();
    }

    private void generate(int num){
        for(int i=0;i<num;i++){
            data.add("Hello World "+i);
        }
    }

    class CustomAsyn extends AsyncTask<String, String , String>{
        private int count=0;
        ArrayAdapter<String> cusAdapter;

        @Override
        protected void onPreExecute() {
            cusAdapter= (ArrayAdapter<String>) listView.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
            Message.message(SlidenerdAsyntask.this, "onPreExecute");
        }

        @Override
        protected void onPostExecute(String s) {
            setProgressBarVisibility(false);
            Message.message(SlidenerdAsyntask.this, "Done Execute with Listview");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            count++;
            cusAdapter.add(values[0]+" Test");
            setProgress((int)((double)(count/data.size())*1000));
            Message.message(SlidenerdAsyntask.this, count+"");
        }

        @Override
        protected String doInBackground(String... strings) {
            //Message.message(SlidenerdAsyntask.this, "doInBackground");
            for(String item : data){
                publishProgress(item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }


    }
}
