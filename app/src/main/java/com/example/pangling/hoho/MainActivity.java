package com.example.pangling.hoho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pangling.hoho.adapter.AdapterMovie;
import com.example.pangling.hoho.model.ModelMovie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelMovie> data = new ArrayList<>();
    AdapterMovie adapter;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    Button cari;
    EditText txtcari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implementasi
        recyclerView = (RecyclerView) findViewById(R.id.rvmovie);
        requestQueue = Volley.newRequestQueue(this);
        cari = (Button) findViewById(R.id.btnCari);
        txtcari = (EditText) findViewById(R.id.txtSearch);

        //method
        isiData();
        setAdapter();
        doSearch();
    }

    private void doSearch(){
        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                String kata;
                if(txtcari.getText().toString().length() == 0){
                    kata = "A";
                }else{
                    kata = txtcari.getText().toString();
                }
                stringRequest = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/search/movie?api_key=293dc4ce4df06b15d37a7f0c1d13f716&language=en-US&query="+kata, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray result = obj.getJSONArray("results");

                            for (int i = 0; i< result.length(); i++){
                                JSONObject datas = result.getJSONObject(i);

                                String id = datas.getString("id");
                                String path = datas.getString("poster_path");
                                String popular = datas.getString("popularity");
                                String title = datas.getString("title");
                                Boolean adult = datas.getBoolean("adult");
                                String overview = datas.getString("overview");
                                String rilis = datas.getString("release_date");
                                String vote = datas.getString("vote_count");
                                String average = datas.getString("vote_average");
                                String adults;

                                if(adult){
                                    adults = "1";
                                }else{
                                    adults = "0";
                                }

                                data.add(new ModelMovie(id,path,popular,title,adults,overview,rilis,vote,average));

                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }


    private void setAdapter(){
        adapter = new AdapterMovie(this, data);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void isiData(){
        stringRequest = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=2bea38317c7da072ccff5b9ad2bcc5a2", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray result = obj.getJSONArray("results");

                    for (int i = 0; i< result.length(); i++){
                        JSONObject datas = result.getJSONObject(i);

                        String id = datas.getString("id");
                        String path = datas.getString("poster_path");
                        String popular = datas.getString("popularity");
                        String title = datas.getString("title");
                        Boolean adult = datas.getBoolean("adult");
                        String overview = datas.getString("overview");
                        String rilis = datas.getString("release_date");
                        String vote = datas.getString("vote_count");
                        String average = datas.getString("vote_average");
                        String adults;

                        if(adult){
                            adults = "1";
                        }else{
                            adults = "0";
                        }

                        data.add(new ModelMovie(id,path,popular,title,adults,overview,rilis,vote,average));

                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(stringRequest);
    }
}
