package com.example.ratanakpek.arrayadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RatanakPek on 11/5/2016.
 */

public class OwnAdapter extends ArrayAdapter<Users> {

    public OwnAdapter(Context context, ArrayList<Users> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getItem also return Users It user ArrayAdapter<Users>
        Users user = getItem(position);

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.ownlayout, null);
        }


        TextView id= (TextView) convertView.findViewById(R.id.id);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView sex = (TextView) convertView.findViewById(R.id.sex);
        id.setText(user.getId());
        name.setText(user.getUsername());
        sex.setText(user.getSex());
        return convertView;


    }
}
