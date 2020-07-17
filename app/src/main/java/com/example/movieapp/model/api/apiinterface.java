package com.example.movieapp.model.api;

import com.example.movieapp.appclass.movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiinterface {

    @GET("movie/popular")
    Call<movies> get_movies(@Query("api_key") String api);

}
