package com.example.vedcomputech.roomdbeg;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by VED COMPUTECH on 4/26/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {

    //Here we use singleton class for Database

    private static RoomDB INSTANCE;

    public abstract UsrIntr userCall() ;

    public static RoomDB getDB(Context context){

        if(INSTANCE == null){

            INSTANCE = Room.databaseBuilder( context.getApplicationContext(), RoomDB.class,
                    "users-database")
                            .allowMainThreadQueries()
                            .build();
        }
        return  INSTANCE;
    }

    public static void DestroyInstance(){
        INSTANCE = null;
    }

}
