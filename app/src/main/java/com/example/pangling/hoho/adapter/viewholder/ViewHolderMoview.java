package com.example.pangling.hoho.adapter.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pangling.hoho.DetailMovieActivity;
import com.example.pangling.hoho.R;
import com.example.pangling.hoho.model.ModelMovie;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewHolderMoview extends RecyclerView.ViewHolder {

    ImageView img;
    TextView judul,desc,tgl, rating, descfull, link;
    RelativeLayout rl;
    public ViewHolderMoview(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.imgHome);
        judul = (TextView) itemView.findViewById(R.id.txtJudulHome);
        desc = (TextView) itemView.findViewById(R.id.txtDesc);
        tgl = (TextView) itemView.findViewById(R.id.txtTgl);
        rl = (RelativeLayout) itemView.findViewById(R.id.rl);
        rating = (TextView) itemView.findViewById(R.id.txtRating);
        descfull = (TextView) itemView.findViewById(R.id.txtDescFULL);
        link = (TextView) itemView.findViewById(R.id.linkgambar);

        //implementasi method
        ngeclick();
    }

    public void setData(ModelMovie data){
        try {

            Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w500"+data.getPosterPath()).into(img);
            judul.setText(data.getTitle());
            if(data.getOverview().length() > 15){
                desc.setText(data.getOverview().substring(0,17)+"...");
            }else {
                desc.setText(data.getOverview());
            }

            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(data.getRilisDate());
            tgl.setText(new SimpleDateFormat("EEE , MMMM d, y").format(date1));
            rating.setText(data.getAverage());
            descfull.setText(data.getOverview());
            link.setText("http://image.tmdb.org/t/p/w500"+data.getPosterPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void ngeclick(){
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemView.getContext(), DetailMovieActivity.class);
                i.putExtra("judul",judul.getText());
                i.putExtra("desc",descfull.getText());
                i.putExtra("date",tgl.getText());
                i.putExtra("rate",rating.getText());
                i.putExtra("gambar",link.getText());
                itemView.getContext().startActivity(i);
            }
        });

    }


}
