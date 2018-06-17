package com.example.vedcomputech.roomdbeg;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by VED COMPUTECH on 4/26/2018.
 */


@Entity(tableName = "user", indices = {@Index(value = {"first_name","last_name","age"}, unique = true)})
public class User {

    //Define the Database table name here

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "age")
    private int age;

    public User(String fname, String lname, int age) {
        this.firstName = fname;
        this.lastName= lname;
        this.age= age;
    }

    public User() {

    }


    //Creat a getter setter here only
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
