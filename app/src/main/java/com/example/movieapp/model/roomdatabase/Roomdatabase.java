package com.example.movieapp.model.roomdatabase;

import android.content.Context;

import androidx.core.util.Pools;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = databaseclass.class,version = 1)
public abstract class Roomdatabase extends RoomDatabase {

    private static RoomDatabase instance;

    public abstract databaseduo notedao();

    public static synchronized RoomDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Roomdatabase.class,
                    "movies_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
