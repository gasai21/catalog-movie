package com.example.pangling.hoho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {

    ImageView img;
    TextView judul, overview, dates, rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        //deklarasi
        img = (ImageView) findViewById(R.id.imgposterfilm);
        judul = (TextView) findViewById(R.id.tvDetailfilm);
        rate = (TextView) findViewById(R.id.detailvote);
        dates = (TextView) findViewById(R.id.tvdetailtanggal);
        overview = (TextView) findViewById(R.id.tvDetailoverview);

        //implementasi method
        setData();
    }

    private  void setData(){
        Intent i = getIntent();
        String foto = i.getStringExtra("gambar");
        Picasso.with(this).load(foto).into(img);
        judul.setText(i.getStringExtra("judul"));
        rate.setText(i.getStringExtra("rate"));
        dates.setText(i.getStringExtra("date"));
        overview.setText(i.getStringExtra("desc"));
    }
}
