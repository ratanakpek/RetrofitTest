package com.example.ratanakpek.gridview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RatanakPek on 11/6/2016.
 */

public class SingleImageVIew extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ImageView imgv = (ImageView) findViewById(R.id.img);
        TextView tv = (TextView) findViewById(R.id.tv);
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
        ImageAdapter imgObj = new ImageAdapter(this);
        imgv.setImageResource(imgObj.obj[position]);

    }
}
