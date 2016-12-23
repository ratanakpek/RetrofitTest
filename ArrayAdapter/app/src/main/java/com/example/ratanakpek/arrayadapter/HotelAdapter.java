package com.example.ratanakpek.arrayadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RatanakPek on 11/5/2016.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {
    private Context context;
    private List<Hotel> hotel;

    public HotelAdapter(Context context, int resource, ArrayList<Hotel> hotel) {
        super(context, resource, hotel);
        this.context=context;
        this.hotel=hotel;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        Hotel item = hotel.get(position);
        ViewHolder viewHolder=null;
    if(view==null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom, null);
        viewHolder=new ViewHolder(view);
        view.setTag(viewHolder);

    }else{
        viewHolder= (ViewHolder) view.getTag();
    }


        viewHolder.title.setText(String.valueOf(item.getTitle()));
        viewHolder.price.setText("Price : $"+String.valueOf(item.getPrice()));
        viewHolder.bed.setText("Bedroom : "+String.valueOf(item.getBed()));
        viewHolder.bathroom.setText("Bathroom: "+String.valueOf(item.getBathroom()));
        viewHolder.carspot.setText("Car : "+String.valueOf(item.getCarspot()));

        int desleng = item.getDesc().length();
        if(desleng>100){
            String leng = item.getDesc().substring(0, 100)+" ... ";
            viewHolder.desc.setText(leng);
            Log.d("Nak", "First Time");
        }else{
            viewHolder.desc.setText(item.getDesc());
            Log.d("Nak", "Other Time");
        }


        int imageid= context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
        viewHolder.image.setImageResource(imageid);

        return view;
    }

    class ViewHolder{
         ImageView image;
         TextView title;
         TextView desc;
         TextView price;
         TextView bed;
         TextView bathroom;
         TextView carspot;


        public ViewHolder(View view) {
            this.image = (ImageView) view.findViewById(R.id.img);
            this.title = (TextView) view.findViewById(R.id.ctitle);
            this.desc = (TextView) view.findViewById(R.id.cdesc);
            this.price = (TextView) view.findViewById(R.id.price);
            this.bed = (TextView) view.findViewById(R.id.bedroom);
            this.bathroom = (TextView) view.findViewById(R.id.bathroom);
            this.carspot = (TextView) view.findViewById(R.id.carspot);
        }
    }
}
