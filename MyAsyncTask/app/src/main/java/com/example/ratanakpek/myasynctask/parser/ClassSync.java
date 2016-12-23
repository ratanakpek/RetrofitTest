package com.example.ratanakpek.myasynctask.parser;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ratanakpek.myasynctask.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by RatanakPek on 11/21/2016.
 */

public class ClassSync extends Activity{

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctaskact);
        img = (ImageView) findViewById(R.id.imgAsyn);

    }

    public void donwloadImage(View view) {
        new ImageDown().execute("http://www.vogella.com/tutorials/AndroidBackgroundProcessing/img/xlooper_messagequeue10.png.pagespeed.ic.rsQc-xXX0V.webp");
    }

    class ImageDown extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            Toast.makeText(ClassSync.this, "onPreExecute", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp =null;
            try{
                URL ulrn = new URL(strings[0]);
                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (null != bmp)
                    return bmp;

            }catch(Exception e){}
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            Toast.makeText(ClassSync.this, "DONE", Toast.LENGTH_SHORT).show();
            img.setImageBitmap(bitmap);
        }
    }

}
