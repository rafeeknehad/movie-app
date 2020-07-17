package com.example.movieapp.model.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Favarite_movies")
public class databaseclass  {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Integer movies_id;

    public databaseclass(Integer movies_id) {
        this.movies_id = movies_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Integer getMovies_id() {
        return movies_id;
    }
}
