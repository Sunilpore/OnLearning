package com.example.vedcomputech.roomdbeg;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VED COMPUTECH on 5/17/2018.
 */

public class Converters {

    @TypeConverter

    //Retrieve back from Database
    public static ArrayList <String> fromString(String value){

        Type listype = new TypeToken<ArrayList <String>>(){}.getType();

        return new Gson().fromJson(value, listype);
    }

    @TypeConverter

    //Insert into the Database
    public static String fromArrayList(ArrayList<String> list){
        Gson gson =new Gson();

        String json = gson.toJson(list);

        return json;
    }

}
