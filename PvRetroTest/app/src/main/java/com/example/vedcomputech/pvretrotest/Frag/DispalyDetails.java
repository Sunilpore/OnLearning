package com.example.vedcomputech.pvretrotest.Frag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vedcomputech.pvretrotest.ApiClient;
import com.example.vedcomputech.pvretrotest.ApiInterface;
import com.example.vedcomputech.pvretrotest.Details;
import com.example.vedcomputech.pvretrotest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ved Computech on 02-04-2018.
 */

public class DispalyDetails extends Fragment {

    TextView paperHeight, paperWidth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.get_details, container, false);

        paperHeight = view.findViewById(R.id.height_view);
        paperWidth = view.findViewById(R.id.width_view);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Details> call = apiInterface.getDetails(3);

        call.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(@NonNull Call<Details> call, @NonNull Response<Details> response) {

                Details dmodel = response.body();
                assert dmodel != null;
                paperHeight.setText(String.valueOf(dmodel.getPaper_height()));
                paperWidth.setText(String.valueOf(dmodel.getPaper_width()));
                Toast.makeText(getContext(), "Mission accomplished", Toast.LENGTH_SHORT).show();
                Log.d("testApi", "Mission successful");
            }

            @Override
            public void onFailure(@NonNull Call<Details> call, @NonNull Throwable t) {

                Log.d("testApi", "Mission fail");
                Toast.makeText(getContext(), "Mission failed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
