package com.example.ratanakpek.fragmenttestagain;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by RatanakPek on 11/9/2016.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> adapter;
    String obj[];
    ListView listview;
    Communicator comm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listview= (ListView) getActivity().findViewById(R.id.listview);
        comm= (Communicator) getActivity();
        obj=getResources().getStringArray(R.array.q);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, obj);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        comm.response(i);
    }
}
