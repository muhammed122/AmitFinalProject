package com.example.amitfinalproject.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.amitfinalproject.data.model.category.CategoriesItem;
import com.example.amitfinalproject.data.model.category.CategoryResponse;
import com.example.amitfinalproject.data.source.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private MutableLiveData<List<CategoriesItem>>categoryLiveData;
    private MutableLiveData<String>messageLiveData;

    public CategoryRepository() {
        categoryLiveData = new MutableLiveData<>();
        messageLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<CategoriesItem>> getCategoryLiveData() {
        return categoryLiveData;
    }

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public void getAllCategories(){
        ApiManager.getProductService().getAllCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                if (response.isSuccessful())
                    categoryLiveData.setValue(response.body().getCategories());
                else
                    messageLiveData.setValue(response.message());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                    messageLiveData.setValue(t.getLocalizedMessage());

            }
        });
    }




}
