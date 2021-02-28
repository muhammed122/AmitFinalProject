package com.example.amitfinalproject.ui.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.product.ProductsItem;
import com.example.amitfinalproject.ui.adapter.ProductAdapter;

import java.util.List;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    RecyclerView productRecycler;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;

    //View model
    private HomeViewModel homeViewModel;


    private void intiRecycler(View v){
        productRecycler=v.findViewById(R.id.product_recycler);
        adapter=new ProductAdapter(getContext());
        layoutManager=new GridLayoutManager(getContext(),2);
        productRecycler.setLayoutManager(layoutManager);
        productRecycler.setAdapter(adapter);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intiRecycler(view);
        homeViewModel=
                new  ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        homeViewModel.getProducts();

        homeViewModel.getProductsLiveData().observe(getViewLifecycleOwner(), new Observer<List<ProductsItem>>() {
            @Override
            public void onChanged(List<ProductsItem> productsItems) {
                adapter.setProductsItems(productsItems);
            }
        });

        homeViewModel.getMessageLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
            }
        });





    }
}