package com.example.pangling.hoho.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.hoho.R;
import com.example.pangling.hoho.model.ModelMovie;

public class ViewHolderMoview extends RecyclerView.ViewHolder {

    ImageView img;
    TextView judul,desc,tgl;
    public ViewHolderMoview(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.imgHome);
        judul = (TextView) itemView.findViewById(R.id.txtJudulHome);
        desc = (TextView) itemView.findViewById(R.id.txtDesc);
        tgl = (TextView) itemView.findViewById(R.id.txtTgl);
    }

    public void setData(ModelMovie data){
        judul.setText(data.getTitle());
        desc.setText(data.getOverview());
        tgl.setText(data.getRilisDate());
    }
}
