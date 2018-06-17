package com.example.vedcomputech.uploadphoto;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.pick_image);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            }
        }

        process_start();

    }


    private void process_start(){

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new MaterialFilePicker()
                    .withActivity(MainActivity.this)
                    .withRequestCode(10)
                    .start();
                }
            });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode ==100 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
            process_start();
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {

        if(requestCode == 10 && resultCode == RESULT_OK){


            progress = new ProgressDialog(MainActivity.this);
            progress.setTitle("Uploading");
            progress.setMessage("Please wait...");
            progress.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    File f = new File(data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH));
                    String contentType = getMimeType(f.getPath());

                    String filePath = f.getAbsolutePath();

                    OkHttpClient client = new OkHttpClient();
                    RequestBody fileBody = RequestBody.create(MediaType.parse(contentType),f);

                    RequestBody requestBody = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("type",contentType)
                            .addFormDataPart("upload_file",filePath.substring(filePath.lastIndexOf("/")+ 1),fileBody)
                            .build();

                    Request request = new Request.Builder()
                            .url("http://192.168.29.35/marvel/uploadfinal.php")
                            .post(requestBody)
                            .build();


                    try {
                        Response response =client.newCall(request).execute();

                        if(!response.isSuccessful()){
                            throw new IOException("ERROR: "+response );
                        }

                    } catch (IOException e) {
                        Log.d("KKR","ERROR");
                        e.printStackTrace();
                    }
                    progress.dismiss();

                }
            }).start();

        }

    }


    private String getMimeType(String path){

        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }



}
