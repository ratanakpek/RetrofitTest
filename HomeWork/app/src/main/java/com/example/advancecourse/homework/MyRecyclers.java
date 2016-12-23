package com.example.advancecourse.homework;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RatanakPek on 11/11/2016.
 */

public class MyRecyclers extends RecyclerView.Adapter<MyRecyclers.OwnViewHolder>{
    private ArrayList<Products> data;
    Communicator comm;

    public MyRecyclers(ArrayList<Products> data, Context context) {
        this.data = data;
        comm= (Communicator) context;
    }

    @Override
    public OwnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new OwnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OwnViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.image.setImageResource(R.drawable.samsung);
        holder.views.setText(data.get(position).getViews());
        holder.date.setText(data.get(position).getDate());
        holder.desc.setText(data.get(position).getDesc());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class OwnViewHolder extends RecyclerView.ViewHolder{
        private TextView title, views, date, desc;
        private ImageView image, overflow;
        private CardView card;

        public OwnViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
            views = (TextView) itemView.findViewById(R.id.tvViews);
            date= (TextView) itemView.findViewById(R.id.tvDates);
            image= (ImageView) itemView.findViewById(R.id.image);
            desc=(TextView)itemView.findViewById(R.id.desc);
            card= (CardView) itemView.findViewById(R.id.cardview);
            overflow= (ImageView) itemView.findViewById(R.id.overflow);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comm.onItemClick(getAdapterPosition());
                }
            });

            overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comm.onMenuImageClick(getAdapterPosition(), view);
                }
            });

        }
    }
}
