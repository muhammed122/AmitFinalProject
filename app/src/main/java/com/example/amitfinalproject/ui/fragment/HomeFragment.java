package com.example.amitfinalproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.api.ApiManager;
import com.example.amitfinalproject.data.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ApiManager.getProductService().getAllProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {

                Toast.makeText(getActivity(), "here", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    Log.d("dddddd", "onResponse: "+response.body().getProducts().get(0).getName());


                } else {
                    Log.d("ddddddddd", "onResponse: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {

                Log.d("ddddddddddd", "onFailure: "+t.getLocalizedMessage());
            }
        });

    }
}