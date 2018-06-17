package com.example.vedcomputech.roomdbeg;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by VED COMPUTECH on 4/26/2018.
 */

@Dao
public interface UsrIntr {

    //All the Query operations should be performed here

    @Query("SELECT * FROM user")
    List <User> getAll();

    @Query("SELECT * FROM user where first_name LIKE :firstName AND  last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT (*) from user")
    int countUser();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);


}
