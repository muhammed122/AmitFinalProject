package com.example.amitfinalproject.ui.fragment.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.amitfinalproject.data.model.product.ProductsItem;
import com.example.amitfinalproject.data.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {


    private LiveData<List<ProductsItem>> productsLiveData;
    private LiveData<String> messageLiveData ;


    public LiveData<List<ProductsItem>> getProductsLiveData() {
        return productsLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    private ProductRepository repository = new ProductRepository();

    public void getProducts() {
        repository.getAllProducts();
        productsLiveData=repository.getProductLiveData();
        messageLiveData=repository.getMessageLiveData();

    }



}
