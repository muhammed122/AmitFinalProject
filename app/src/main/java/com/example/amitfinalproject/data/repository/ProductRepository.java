package com.example.amitfinalproject.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.amitfinalproject.data.model.product.Product;
import com.example.amitfinalproject.data.model.product.ProductsResponse;
import com.example.amitfinalproject.data.source.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private MutableLiveData<List<Product>> productLiveData;
    private MutableLiveData<String> messageLiveData;

    public MutableLiveData<List<Product>> getProductLiveData() {
        return productLiveData;
    }

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public ProductRepository() {
        productLiveData = new MutableLiveData<>();
        messageLiveData = new MutableLiveData<>();
    }


    public void getAllProducts(){

        Log.d("dddddddd", "getAllProducts: test");
        ApiManager.getProductService().getAllProducts()
                .enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                    if(response.isSuccessful()){
                        productLiveData.setValue(response.body().getProducts());
                        Log.d("ddddddd", "onResponse: "+response.code());

                    }else{
                        Log.d("ddddddd", "onResponse: "+response.code());
                    }


                    }
                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                        messageLiveData.setValue(t.getLocalizedMessage());
                        Log.d("dddddddd", "onFailure: "+t.getLocalizedMessage());

                    }
                });



    }





}
