package com.example.amitfinalproject.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.amitfinalproject.data.model.product.ProductsItem;
import com.example.amitfinalproject.data.model.product.ProductsResponse;
import com.example.amitfinalproject.data.source.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private MutableLiveData<List<ProductsItem>> productLiveData;
    private MutableLiveData<String> messageLiveData;

    public MutableLiveData<List<ProductsItem>> getProductLiveData() {
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

        ApiManager.getProductService().getAllProducts()
                .enqueue(new Callback<ProductsResponse>() {
                    @Override
                    public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                    if(response.isSuccessful()){
                        productLiveData.setValue(response.body().getProducts());
                    }

                    }
                    @Override
                    public void onFailure(Call<ProductsResponse> call, Throwable t) {
                        messageLiveData.setValue(t.getLocalizedMessage());
                    }
                });



    }





}
