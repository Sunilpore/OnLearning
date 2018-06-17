package com.example.vedcomputech.bitmapeg;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements Medium{

    String name="Converter";
    byte[] encodeData,decodeData;

    ImageView img;
    Button button;
    Sample sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Sample(this));
        //setContentView(R.layout.activity_main);

        img= (ImageView) findViewById(R.id.Bitmap_image);
        button= (Button) findViewById(R.id.set_img);
        //sample.setListener(this);

        try {

            encodeData = name.getBytes("UTF-8");
            String base64 = Base64.encodeToString(encodeData,Base64.DEFAULT);
            decodeData=Base64.decode(base64,Base64.DEFAULT);

//            encodeData=Base64.encode(name.getBytes(),Base64.DEFAULT);
//            decodeData=Base64.decode(encodeData,Base64.DEFAULT);

            Log.d("check","Encode:"+base64);
            Log.d("check","Decode:"+new String(decodeData));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //final Bitmap bitmap = BitmapFactory.decodeByteArray(decodeData, 0, decodeData.length);


        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Sample.class);
                startActivity(i);

                img.setImageBitmap(bitmap);

            }
        });*/

    }

    @Override
    public void dataListenernow(Bitmap bmap) {

        //img.setImageBitmap(bmap);
    }

    /*@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        tv.setText(name);
        tv.setDrawingCacheEnabled(true);

        Bitmap bitmap= Bitmap.createBitmap(tv.getDrawingCache());
        Boolean status=false;
        try {

            status =bitmap.compress(Bitmap.CompressFormat.PNG,100,new FileOutputStream(Environment.getExternalStorageDirectory()+"/bitmap.png"));
            Log.d("check","STATUS2:"+status);
            img.setImageBitmap(bitmap);

        } catch (FileNotFoundException e) {
            Log.d("check","STATUS:"+e);
            e.printStackTrace();
        }
    }*/

}











