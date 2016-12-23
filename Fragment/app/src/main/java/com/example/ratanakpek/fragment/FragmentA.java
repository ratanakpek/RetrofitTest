package com.example.ratanakpek.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by RatanakPek on 11/9/2016.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{
    ArrayAdapter<String> adapter;
    ListView listview;
    Communicator comm;
    String obj[];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listview= (ListView) getActivity().findViewById(R.id.listview);
        obj=getResources().getStringArray(R.array.question);
        comm= (Communicator) getActivity();
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1 , obj);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        comm.reponse(i);
    }
}
