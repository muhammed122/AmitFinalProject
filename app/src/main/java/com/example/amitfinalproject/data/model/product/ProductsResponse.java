package com.example.amitfinalproject.data.model.product;

import java.util.List;

import com.example.amitfinalproject.data.model.product.ProductsItem;
import com.google.gson.annotations.SerializedName;

public class ProductsResponse{

	@SerializedName("products")
	private List<ProductsItem> products;

	public List<ProductsItem> getProducts(){
		return products;
	}
}