package com.addev.mysqlmelodic.minebrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MySQL Melodic on 23/09/2016.
 */
public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyViewHolder> {

    private List<Jadwal> jadwalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView makul, jam, rate;
        public ImageView avatar, bintang;

        public MyViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.ava);
            makul = (TextView)itemView.findViewById(R.id.makul);
            jam = (TextView)itemView.findViewById(R.id.jam);
            bintang = (ImageView)itemView.findViewById(R.id.star) ;
            rate = (TextView)itemView.findViewById(R.id.rate);
        }
    }

    public JadwalAdapter(List<Jadwal> jadwalList){
        this.jadwalList = jadwalList;
    }

    @Override
    public JadwalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jadwal_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JadwalAdapter.MyViewHolder holder, int position) {
        Jadwal jadwal = jadwalList.get(position);
        holder.avatar.setImageResource(jadwal.getImageUrl());
        holder.makul.setText(jadwal.getMakul());
        holder.jam.setText(jadwal.getJam());
        holder.bintang.setImageResource(jadwal.getBintang());
        holder.rate.setText(jadwal.getRate());
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }
}
