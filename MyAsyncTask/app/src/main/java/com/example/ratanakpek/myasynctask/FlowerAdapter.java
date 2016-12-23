package com.example.ratanakpek.myasynctask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by RatanakPek on 11/19/2016.
 */

public class FlowerAdapter extends ArrayAdapter<Flower> {
    private Context context;
    private List<Flower> flowerlist;
    private LruCache<Integer, Bitmap> imagecache;


    public FlowerAdapter(Context context, int resource, List<Flower> flower) {
        super(context, resource, flower);
        this.context = context;
        this.flowerlist = flower;

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory/8;
        imagecache=new LruCache<>(cacheSize);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_display, parent, false);

        Flower flowe = flowerlist.get(position);
        TextView tv = (TextView) v.findViewById(R.id.titles);
        tv.setText(flowe.getName());


        Bitmap bitm = imagecache.get(flowe.getProductid());

        if (bitm != null) {
            ImageView img = (ImageView) v.findViewById(R.id.images);
            img.setImageBitmap(flowe.getBitmap());
        }else{
            FlowerAndView container = new FlowerAndView();
            container.flower=flowe;
            container.view=v;

            ImageLoader loader = new ImageLoader();
            loader.execute(container);
        }


        return v;
    }

    class FlowerAndView {
        public Flower flower;
        public View view;
        public Bitmap bitmap;
    }


    private class ImageLoader extends AsyncTask<FlowerAndView, Void, FlowerAndView> {

        @Override
        protected FlowerAndView doInBackground(FlowerAndView... flowerAndViews) {
            FlowerAndView container = flowerAndViews[0];
            Flower flo = container.flower;
            String imageurl = MainActivity.PHOTO + flo.getPhoto();
            try {
                InputStream in = (InputStream) new URL(imageurl).getContent();
                Bitmap bit = BitmapFactory.decodeStream(in);
                flo.setBitmap(bit);
                in.close();

                container.bitmap = bit;
                return container;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(FlowerAndView flowerAndView) {
            ImageView img = (ImageView) flowerAndView.view.findViewById(R.id.images);
            //Display bitmap
            img.setImageBitmap(flowerAndView.bitmap);
            //Save it for future use
            //flowerAndView.flower.setBitmap(flowerAndView.bitmap);
            imagecache.put(flowerAndView.flower.getProductid(), flowerAndView.bitmap);
        }
    }

}
