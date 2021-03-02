package com.example.amitfinalproject.ui.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.model.product.Product;
import com.example.amitfinalproject.helper.TokenManager;
import com.example.amitfinalproject.ui.adapter.product.ProductAdapter;
import com.example.amitfinalproject.ui.adapter.product.ProductClickListener;

import java.util.List;


public class HomeFragment extends Fragment implements ProductClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    //View model
    private HomeViewModel homeViewModel;

    private NavController navController;


    RecyclerView productRecycler;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;

    private void intiRecycler(View v) {
        productRecycler = v.findViewById(R.id.product_recycler);
        adapter = new ProductAdapter(getContext(), this);
        layoutManager = new GridLayoutManager(getContext(), 2);
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
        navController = Navigation.findNavController(view);

        intiRecycler(view);
        homeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        homeViewModel.getProducts();

        homeViewModel.getProductsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProducts(products);
            }
        });

        homeViewModel.getMessageLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });


        homeViewModel.getAddCartResponseLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });

        homeViewModel.getMessageCartLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void showProductDetails(Product product) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        navController
                .navigate(R.id.action_homeFragment_to_productDetailsFragment, bundle);

    }

    @Override
    public void addProductToCart(Product product) {
        TokenManager tokenManager = new TokenManager(getContext());
        String token = tokenManager.getToken();
        homeViewModel.addProductToCart(product.getId(), token, 1);

    }
}