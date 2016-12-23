package com.example.ratanakpek.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RatanakPek on 11/6/2016.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context con = parent.getContext();
        LayoutInflater layout = new LayoutInflater.from(con);
        View convertView = layout.inflate(R.layout.layout, parent, null);
        ViewHolder holder = new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
        Contact contac = mContac.get(position);
        // Set item views based on your views and data model
        TextView textView = holder.id;
        textView.setText(contac.getName());
        Button button = holder.name;
        button.setText("Message");
    }

    @Override
    public int getItemCount() {
        return mContac.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private Button name;

        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.id);
            name=(Button)itemView.findViewById(R.id.name);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private Context mContext;
    private List<Contact> mContac;

    public ContactAdapter(Context mContext, List<Contact> mContac) {
        this.mContext = mContext;
        this.mContac = mContac;
    }

    public Context getmContext() {
        return mContext;
    }
}
