package com.example.amitfinalproject.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsResponse{

	@SerializedName("products")
	private List<ProductsItem> products;

	public List<ProductsItem> getProducts(){
		return products;
	}
}