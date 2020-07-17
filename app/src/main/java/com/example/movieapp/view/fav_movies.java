package com.example.movieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.movieapp.R;
import com.example.movieapp.appclass.Result;
import com.example.movieapp.model.roomdatabase.databaseclass;
import com.example.movieapp.presenter.fav_movies_interface;
import com.example.movieapp.presenter.fav_movies_presenter;

import java.util.ArrayList;
import java.util.List;

public class fav_movies extends AppCompatActivity implements fav_movies_interface {

    public static fav_movies_presenter fav_movies_presenterx;
    private RecyclerView recyclerViewx;
    private Example_adapter example_adapterx;
    private RecyclerView.LayoutManager layoutManagerx;
    public static String id_paramter = "id_movies";
    public static int code_mainactivity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies2);
        call_viewmodel();
        recyclerViewx = findViewById(R.id.fav_recyclerview);
    }

    public void call_viewmodel()
    {
        fav_movies_presenterx = new fav_movies_presenter(this);
    }

    @Override
    public void getdata_frompresenter(final List<databaseclass> databaseclassesx) {
        final List<Result> new_list=new ArrayList<>();
        List<Result> old_list = MainActivity.resultList;
        for(databaseclass item : databaseclassesx)
        {
            for(Result result : old_list)
            {
                if(result.getId().equals(item.getMovies_id()))
                {
                    new_list.add(result);
                    break;
                }
            }
        }
        example_adapterx = new Example_adapter(new_list,this);
        recyclerViewx.setAdapter(example_adapterx);
        recyclerViewx.setHasFixedSize(true);
        recyclerViewx.setLayoutManager(new LinearLayoutManager(this));
        example_adapterx.setonitemclicklisinear(new Example_adapter.recyclerview_lisiner() {
            @Override
            public void onclick_recyclerview(int position) {
                Intent myIntent = new Intent(getApplicationContext(),moviesdetailactivity.class);
                myIntent.putExtra(id_paramter,databaseclassesx.get(position).getId());
                myIntent.putExtra(MainActivity.object_pass,new_list.get(position));
                myIntent.putExtra(MainActivity.parent_activity,"fav_movies");
                startActivity(myIntent);
            }
        });
    }
}