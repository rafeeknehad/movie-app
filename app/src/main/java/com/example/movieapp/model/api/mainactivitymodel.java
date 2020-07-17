package com.example.movieapp.model.api;

import android.content.Context;
import android.widget.Toast;

import com.example.movieapp.appclass.Result;
import com.example.movieapp.appclass.movies;
import com.example.movieapp.model.api.apiinterface;
import com.example.movieapp.model.api.interface_mainactivity_model_presenter;
import com.example.movieapp.presenter.mainactivity_presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mainactivitymodel {
    private final String api_key = "939d60a07bf55c9dc7b0a3a0db237e02";
    private List<Result> resultList = new ArrayList<>();
    private Context mContext;
    public interface_mainactivity_model_presenter minterface_mainactivity_model;

    public mainactivitymodel(Context mContext) {
        this.mContext = mContext;
        minterface_mainactivity_model = new mainactivity_presenter(mContext,1);
    }

    public void do_retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiinterface apiinterfacex = retrofit.create(apiinterface.class);
        Call<movies> call = apiinterfacex.get_movies(api_key);
        call.enqueue(new Callback<movies>() {
            @Override
            public void onResponse(Call<movies> call, Response<movies> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(mContext, "Error " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                movies moviesx = response.body();
                List<Result> results = moviesx.getResults();
                resultList.addAll(results);
                minterface_mainactivity_model.getmovies_from_model(resultList);
            }

            @Override
            public void onFailure(Call<movies> call, Throwable t) {
                Toast.makeText(mContext,
                        "Error Connection",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

