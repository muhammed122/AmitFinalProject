package com.example.amitfinalproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.category.CategoriesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {


    private List<CategoriesItem> categoriesItems = new ArrayList<>();

    public void setCategoriesItems(List<CategoriesItem> categoriesItems) {
        this.categoriesItems = categoriesItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        CategoriesItem cate = categoriesItems.get(position);
        if (cate != null) {
            holder.categoryName.setText(cate.getName());
            Picasso.get().load(cate.getAvatar()).into(holder.categoryImage);
        }

    }

    @Override
    public int getItemCount() {
        return categoriesItems.size();
    }


    static class CategoryHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryName = itemView.findViewById(R.id.category_name);


        }
    }
}
