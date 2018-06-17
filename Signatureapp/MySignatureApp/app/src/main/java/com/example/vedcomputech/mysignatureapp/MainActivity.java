package com.example.vedcomputech.mysignatureapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;

public class MainActivity extends AppCompatActivity {

    SignaturePad signaturePad;
    Button save,clear,next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signaturePad=findViewById(R.id.signature_pad);
        save=findViewById(R.id.save_button);
        clear=findViewById(R.id.clear_button);
        next=findViewById(R.id.next_button);

        save.setEnabled(false);
        clear.setEnabled(false);
        next.setEnabled(false);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);

        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                save.setEnabled(true);
                clear.setEnabled(true);
            }

            @Override
            public void onClear() {
                save.setEnabled(false);
                clear.setEnabled(false);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Save....", Toast.LENGTH_SHORT).show();
                next.setEnabled(true);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signaturePad.clear();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap signBmap=signaturePad.getSignatureBitmap();
                Constant.bitmap = signBmap;

                Intent i=new Intent(MainActivity.this,ShowSignature.class);
                startActivity(i);
            }
        });


    }
}
