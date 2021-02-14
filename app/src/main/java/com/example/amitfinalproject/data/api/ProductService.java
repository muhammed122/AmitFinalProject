package com.example.amitfinalproject.data.api;

import com.example.amitfinalproject.data.model.ProductsItem;
import com.example.amitfinalproject.data.model.ProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {


  @GET("api/products")
  Call<ProductsResponse> getAllProducts();

}
