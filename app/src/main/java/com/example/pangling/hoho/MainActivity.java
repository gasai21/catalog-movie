package com.example.pangling.hoho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pangling.hoho.adapter.AdapterMovie;
import com.example.pangling.hoho.model.ModelMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelMovie> data = new ArrayList<>();
    AdapterMovie adapter;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implementasi
        recyclerView = (RecyclerView) findViewById(R.id.rvmovie);
        requestQueue = Volley.newRequestQueue(this);

        //method
        isiData();
        setAdapter();
    }

    private void setAdapter(){
        adapter = new AdapterMovie(this, data);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void isiData(){
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
        data.add(new ModelMovie("1","dasdas","dasdas","dasda","dasdas","dasda","dasdsa","dasda","dasda"));
    }
}
