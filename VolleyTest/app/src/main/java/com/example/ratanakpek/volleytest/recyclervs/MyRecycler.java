package com.example.ratanakpek.volleytest.recyclervs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratanakpek.volleytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RatanakPek on 11/20/2016.
 */

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.OwnViewHolder> {
    private ArrayList<Product> productslist;


    public MyRecycler(ArrayList<Product> products) {
        this.productslist=products;
    }

    @Override
    public MyRecycler.OwnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcard, parent, false);
        return new OwnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OwnViewHolder holder, int position) {
        holder.name.setText(productslist.get(position).getName());
        holder.processor.setText(productslist.get(position).getProcessor());
        holder.ram.setText(productslist.get(position).getRam());
        holder.img.setImageResource(R.drawable.wook);
    }


    @Override
    public int getItemCount() {
        return productslist.size();
    }

    class OwnViewHolder extends RecyclerView.ViewHolder{
        TextView name, ram, processor;
        ImageView img;

        public OwnViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.cardName);
            ram= (TextView) itemView.findViewById(R.id.cardRam);
            processor= (TextView) itemView.findViewById(R.id.cardProcessor);
            img= (ImageView) itemView.findViewById(R.id.cardImage);

        }
    }
}
