package com.example.ratanakpek.fragmenttestagain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by RatanakPek on 11/9/2016.
 */

public class FragmentB extends FragmentA {
    TextView tv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv= (TextView) getActivity().findViewById(R.id.answer);
    }

    public void setText(String str){
        tv.setText(str);
    }
}
