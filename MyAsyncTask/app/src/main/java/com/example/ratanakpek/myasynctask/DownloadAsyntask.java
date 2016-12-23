package com.example.ratanakpek.myasynctask;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by RatanakPek on 11/18/2016.
 */

public class DownloadAsyntask extends Activity implements AdapterView.OnItemClickListener {
    EditText query;
    ListView listview;
    ProgressBar progress;
    String[] ImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloadimages);
        query = (EditText) findViewById(R.id.edtQuery);
        listview = (ListView) findViewById(R.id.listviews);
        ImageList = getResources().getStringArray(R.array.urls);
        progress = (ProgressBar) findViewById(R.id.progresbar);
        listview.setOnItemClickListener(this);

    }

    public void download(View view) {
        if (query.getText().toString() != null && query.getText().toString().length() > 0) {
            CustomAsyn obj = new CustomAsyn();
            obj.execute(query.getText().toString());
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        query.setText(ImageList[i]);
    }


    class CustomAsyn extends AsyncTask<String, Integer, Boolean> {

        private int  contentLeng=-1;
        private int counter=0;
        private int calculateprogress=0;
        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            calculateprogress=(int)(((double)values[0]/contentLeng)*100);
            progress.setProgress(calculateprogress);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progress.setVisibility(View.GONE);
        }

        @Override
        protected Boolean doInBackground(String... params) {

            boolean successful = false;
            URL downloadURL = null;
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            FileOutputStream fileOutPutStream = null;
            File file = null;

            try {
                downloadURL= new URL(params[0]);
                connection= (HttpURLConnection) downloadURL.openConnection();
                contentLeng=connection.getContentLength();
                inputStream=connection.getInputStream();


               file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/" +
                       ""+Uri.parse(params[0]).getLastPathSegment());
                fileOutPutStream= new FileOutputStream(file);

                int read=-1;
               byte[] buffer = new byte[1024];

                while((read=inputStream.read(buffer))!=-1){
                    fileOutPutStream.write(buffer, 0 ,read);
                    counter=counter+read;
                    Log.d("nak", counter+"");
                    publishProgress(counter);
                }
                successful=true;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
               /* runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setVisibility(View.GONE);
                    }
                });*/
                if(connection!=null){
                    connection.disconnect();
                }
                if(inputStream!=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fileOutPutStream!=null){
                    try {
                        fileOutPutStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return successful;
        }
    }
}
