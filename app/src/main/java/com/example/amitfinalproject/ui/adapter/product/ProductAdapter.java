package com.example.amitfinalproject.ui.adapter.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.product.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> products = new ArrayList<>();
    private Context context;
    private ProductClickListener clickListener;


    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context , ProductClickListener productClickListener) {
        this.context = context;
        this.clickListener=productClickListener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);
        if (product != null) {
            Picasso.get().load(product.getAvatar()).into(holder.productImage);
            holder.productName.setText(product.getName());
            holder.productTitle.setText(product.getTitle());
            holder.productPrice.setText(String.valueOf(product.getPriceFinal()));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do anything

                clickListener.showProductDetails(product);

            }
        });

        holder.addCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickListener.addProductToCart(product);
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productTitle, productPrice;
        ImageButton addCartBtn;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productTitle = itemView.findViewById(R.id.product_title);
            productPrice = itemView.findViewById(R.id.product_price);
            addCartBtn=itemView.findViewById(R.id.add_cart_btn);

        }
    }
}
