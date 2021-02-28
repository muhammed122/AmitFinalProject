package com.example.amitfinalproject.data.source.api;

import com.example.amitfinalproject.data.model.category.CategoryResponse;
import com.example.amitfinalproject.data.model.product.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {


  @GET("api/products")
  Call<ProductsResponse> getAllProducts();


  @GET("api/categories")
  Call<CategoryResponse>getAllCategories();

}
