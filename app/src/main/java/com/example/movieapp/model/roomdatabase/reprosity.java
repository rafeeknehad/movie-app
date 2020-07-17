package com.example.movieapp.model.roomdatabase;

import android.content.Context;

import java.util.List;

import androidx.lifecycle.LiveData;

public class reprosity {

    private Roomdatabase roomdatabasex;
    private databaseduo datadao;

    public reprosity(Context context)
    {
        roomdatabasex = (Roomdatabase) Roomdatabase.getInstance(context);
        datadao = roomdatabasex.notedao();
    }

    public void insert(databaseclass data)
    {
        datadao.insert(data);
    }

    public void delete(databaseclass data)
    {
        datadao.delete(data);
    }

    public LiveData<List<databaseclass>> getalldata()
    {
        return datadao.getalldata();
    }
}
