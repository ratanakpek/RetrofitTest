package com.example.ratanakpek.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by RatanakPek on 11/6/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;

    ImageAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return obj.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image = (ImageView) view;
        if (image==null){
            image = new ImageView(context);
            image.setLayoutParams(new GridView.LayoutParams(90,90));
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setPadding(5, 5, 5, 5);
        }else{
            image = (ImageView) view;
        }

        image.setImageResource(obj[i]);
        return image;
    }

    public Integer[] obj = {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7,
            R.drawable.sample_6,
            R.drawable.sample_0,
            R.drawable.sample_3,
            R.drawable.sample_0,
            R.drawable.sample_4,
            R.drawable.sample_2,
            R.drawable.sample_1,
            R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,R.drawable.sample_1,
            R.drawable.sample_1



    };
}
