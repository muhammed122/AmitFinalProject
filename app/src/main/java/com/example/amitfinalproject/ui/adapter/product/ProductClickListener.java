package com.example.amitfinalproject.ui.adapter.product;

import com.example.amitfinalproject.data.model.product.Product;

public interface ProductClickListener {

    void showProductDetails(Product product);

    void addProductToCart(Product product);


}
