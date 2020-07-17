package com.example.movieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movieapp.R;
import com.example.movieapp.appclass.Result;
import com.example.movieapp.presenter.fav_movies_presenter;
import com.example.movieapp.presenter.main_presenter_interface;
import com.example.movieapp.presenter.mainactivity_presenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements main_presenter_interface {

    public static final String TAG ="MainActivity";
    public static final String parent_activity ="parent_activity";
    public static final String object_pass = "movies_obj";
    private RecyclerView recyclerView_moview;
    private mainactivity_presenter mainactivityPresenter;
    private Example_adapter adapter;
    public static List<Result> resultList;
    private FloatingActionButton floatingActionButtonx;
    public static int mainactivitycode = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_moview = findViewById(R.id.recyclerview_movies);
        mainactivityPresenter =new mainactivity_presenter(this);
        floatingActionButtonx = findViewById(R.id.fav_form);
        floatingActionButtonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),fav_movies.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void back_data(List<Result> movies) {
        resultList = movies;
        build_adapter(movies);
    }

    private void build_adapter(final List<Result> movies)
    {
        adapter = new Example_adapter(movies,this);
        recyclerView_moview.setHasFixedSize(true);
        recyclerView_moview.setAdapter(adapter);
        recyclerView_moview.setLayoutManager(new LinearLayoutManager(this));
        adapter.setonitemclicklisinear(new Example_adapter.recyclerview_lisiner() {
            @Override
            public void onclick_recyclerview(int position) {
                Intent myintent = new Intent(getApplicationContext(),moviesdetailactivity.class);
                myintent.putExtra(object_pass, movies.get(position));
                myintent.putExtra(parent_activity,"Main_activity");
                startActivity(myintent);
            }
        });
    }
}