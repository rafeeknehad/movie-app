package com.example.movieapp.model.roomdatabase;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class databaseviewmodel extends AndroidViewModel {

    private LiveData<List<databaseclass>> alldata;
    private reprosity reprosityx;
    public databaseviewmodel(@NonNull Application application) {
        super(application);
        reprosityx = new reprosity(application);
        alldata = reprosityx.getalldata();
    }

    public void insert(databaseclass Data)
    {
        reprosityx.insert(Data);
    }

    public void delete(databaseclass databaseclassx)
    {
        reprosityx.delete(databaseclassx);
    }

    public LiveData<List<databaseclass>> getAlldata()
    {
        return alldata;
    }
}
