package com.example.movieapp.presenter;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.movieapp.model.roomdatabase.Roomdatabase;
import com.example.movieapp.model.roomdatabase.databaseclass;
import com.example.movieapp.model.roomdatabase.databaseviewmodel;
import com.example.movieapp.view.fav_movies;

import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class fav_movies_presenter {
    private Context context;
    private Roomdatabase roomdatabase;
    private fav_movies_interface fav_movies_interfacex;
    public static databaseviewmodel databaseviewmodelx;
    public  fav_movies_presenter(final Context context) {
        this.context = context;
        fav_movies_interfacex = (fav_movies_interface) context;
        databaseviewmodelx = ViewModelProviders.of((FragmentActivity) context).get(databaseviewmodel.class);
        databaseviewmodelx.getAlldata().observe((LifecycleOwner) context, new Observer<List<databaseclass>>() {
            @Override
            public void onChanged(List<databaseclass> databaseclasses) {
                fav_movies_interfacex.getdata_frompresenter(databaseclasses);
            }
        });
    }
}
