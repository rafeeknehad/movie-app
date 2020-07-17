package com.example.movieapp.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.appclass.Result;
import com.example.movieapp.model.roomdatabase.databaseclass;
import com.example.movieapp.presenter.fav_movies_presenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class moviesdetailactivity extends AppCompatActivity {

    private static final String TAG="moviesdetailactivity";
    private int width;
    private RelativeLayout relativeLayout;
    private TextView date;
    private TextView overview;
    private TextView title;
    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView progrees;
    private FloatingActionButton floatingActionButton;
    private Result result;
    private String parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviesdetailactivity);
        result = getIntent().getParcelableExtra(MainActivity.object_pass);
        parent = getIntent().getStringExtra(MainActivity.parent_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        floatingActionButton =findViewById(R.id.floatingbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseclass databaseclassx = new databaseclass(result.getId());
                if(parent.equals("Main_activity")) {
                    fav_movies_presenter.databaseviewmodelx.insert(databaseclassx);
                }
                else if(parent.equals("fav_movies"))
                {
                    int id = getIntent().getIntExtra(fav_movies.id_paramter,-1);
                    databaseclassx.setId(id);
                    fav_movies_presenter.databaseviewmodelx.delete(databaseclassx);
                }
            }
        });
        set_Data();
    }

    private void set_Data()
    {
        date = findViewById(R.id.textdate);
        overview = findViewById(R.id.Overviewtxt);
        title = findViewById(R.id.textviewtitle);
        imageView = findViewById(R.id.imageviewmovies);
        progrees = findViewById(R.id.progresstext);
        progressBar = findViewById(R.id.progress_circular);
        String url = "http://image.tmdb.org/t/p/w500/";
        url = url + result.getBackdropPath();
        Picasso.with(this).load(url).resize(width,500).into(imageView);
        date.setText(result.getReleaseDate());
        overview.setText(result.getOverview());
        title.setText(result.getTitle());
        Double res = result.getPopularity() / 360;
        Double value = res*100;
        progrees.setText(String.valueOf(value.intValue())+"%");
        progressBar.setProgress(value.intValue());
    }
}