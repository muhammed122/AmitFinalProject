package com.example.amitfinalproject.data.source.api;

import com.example.amitfinalproject.data.model.AddCartResponse;
import com.example.amitfinalproject.data.model.category.CategoryResponse;
import com.example.amitfinalproject.data.model.product.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ProductService {


    @GET("api/products")
    Call<ProductsResponse> getAllProducts();


    @PUT("api/user/products/{id}")
    Call<AddCartResponse> addProductToCart(
            @Path("id")int id ,
            @Header("Authorization") String token,
            @Query("amount") int amount
    );

    @GET("api/categories")
    Call<CategoryResponse> getAllCategories();

}
