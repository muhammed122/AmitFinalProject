package com.example.amitfinalproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.product.Product;
import com.squareup.picasso.Picasso;


public class ProductDetailsFragment extends Fragment {




    Product product;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            product=(Product) getArguments().
                    getSerializable("product");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    ImageView imageView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView=view.findViewById(R.id.product_image_details);

        Picasso.get().load(product.getAvatar()).into(imageView);

    }
}