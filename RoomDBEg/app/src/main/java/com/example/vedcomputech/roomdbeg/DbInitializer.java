package com.example.vedcomputech.roomdbeg;

import android.annotation.SuppressLint;
import android.arch.persistence.room.RoomDatabase;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by VED COMPUTECH on 4/26/2018.
 */

class DbInitializer {

    private RoomDB db;
    private List<User> userList;

     DbInitializer(RoomDB db) {
        this.db = db;
        MyAsyncDb async = new MyAsyncDb();
        async.execute();
    }

    private void setUserData() {
/*        User user =new User();
        user.setFirstName("Stank");
        user.setLastName("JJ");
        user.setAge(25);
        db.userCall().insertAll(user);
        userList=db.userCall().getAll();*/

try {
    db.userCall().insertAll(new User("Ram", "Jaiswal", 25));
    db.userCall().insertAll(new User("Atul", "Narang", 24));
    db.userCall().insertAll(new User("Akshay", "Shinde", 23));
} catch (SQLiteConstraintException e){
    Log.d("RoomTestE", "ERROR: "+e.getMessage());
}
        userList=db.userCall().getAll();

        int i=0;
        for(Object ob:userList) {
            Log.d("RoomTest", "" + userList.size() + "\tName" + userList.get(i).getFirstName() + " " + userList.get(i).getLastName() + "\tAge" + userList.get(i).getAge());
            i++;
        }

    }


    @SuppressLint("StaticFieldLeak")
    private class MyAsyncDb extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            setUserData();
            return null;
        }


    }

}
