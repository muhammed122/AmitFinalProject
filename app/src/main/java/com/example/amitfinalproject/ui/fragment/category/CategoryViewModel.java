package com.example.amitfinalproject.ui.fragment.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.amitfinalproject.data.model.category.CategoriesItem;
import com.example.amitfinalproject.data.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private LiveData<List<CategoriesItem>>cateLiveData;
    private LiveData<String >messageLiveData;

    private CategoryRepository repository = new CategoryRepository();

    public LiveData<List<CategoriesItem>> getCateLiveData() {
        return cateLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }


    public void getAllCategories(){
        repository.getAllCategories();
        cateLiveData=repository.getCategoryLiveData();
        messageLiveData=repository.getMessageLiveData();
    }
}
