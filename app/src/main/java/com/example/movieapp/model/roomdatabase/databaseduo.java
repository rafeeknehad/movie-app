package com.example.movieapp.model.roomdatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface databaseduo {

    @Insert
    void insert(databaseclass databaseclassx);

    @Delete
    void delete(databaseclass databaseclassx);

    @Query("select * from Favarite_movies")
    LiveData<List<databaseclass>> getalldata();

}
