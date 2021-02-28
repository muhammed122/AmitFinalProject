package com.example.amitfinalproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.product.ProductsItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<ProductsItem> productsItems = new ArrayList<>();
    private Context context;

    public void setProductsItems(List<ProductsItem> productsItems) {
        this.productsItems = productsItems;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        return new ProductHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
            ProductsItem product = productsItems.get(position);
            if(product!=null){
                Picasso.get().load(product.getAvatar()).into(holder.productImage);
                holder.productName.setText(product.getName());
                holder.productTitle.setText(product.getTitle());
                holder.productPrice.setText(String.valueOf(product.getPriceFinal()));
            }

    }

    @Override
    public int getItemCount() {
        return productsItems.size();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productTitle, productPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productTitle = itemView.findViewById(R.id.product_title);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
