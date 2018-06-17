package com.example.vedcomputech.roomdbeg;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;
        btn =findViewById(R.id.btn_click);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbInitializer dbObj= new DbInitializer(RoomDB.getDB(mContext));
            }
        });

    }


    @Override
    protected void onDestroy() {
        RoomDB.DestroyInstance();
        super.onDestroy();
    }

}
