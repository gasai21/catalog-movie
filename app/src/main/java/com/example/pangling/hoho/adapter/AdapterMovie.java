package com.example.pangling.hoho.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangling.hoho.R;
import com.example.pangling.hoho.adapter.viewholder.ViewHolderMoview;
import com.example.pangling.hoho.model.ModelMovie;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ModelMovie> data;

    public AdapterMovie(Context context, ArrayList<ModelMovie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutmovie, parent, false);
        return new ViewHolderMoview(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderMoview){
            ((ViewHolderMoview) holder).setData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
