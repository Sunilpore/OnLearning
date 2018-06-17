package com.example.vedcomputech.mysignatureapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowSignature extends AppCompatActivity {

    ImageView image;
    Button display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_signature);

        image=findViewById(R.id.show_sign);
        display=findViewById(R.id.show_button);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image.setImageBitmap(Constant.bitmap);
            }
        });

    }
}
