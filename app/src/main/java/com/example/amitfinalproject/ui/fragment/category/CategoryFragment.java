package com.example.amitfinalproject.ui.fragment.category;

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
import com.example.amitfinalproject.data.model.category.CategoriesItem;
import com.example.amitfinalproject.ui.adapter.CategoryAdapter;

import java.util.List;


public class CategoryFragment extends Fragment {

    RecyclerView productRecycler;
    RecyclerView.LayoutManager layoutManager;
    CategoryAdapter adapter;

    private void intiRecycler(View v) {
        productRecycler = v.findViewById(R.id.category_recycler);
        adapter = new CategoryAdapter();
        layoutManager = new GridLayoutManager(getContext(), 2);
        productRecycler.setLayoutManager(layoutManager);
        productRecycler.setAdapter(adapter);
    }

    //view model
    CategoryViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intiRecycler(view);


        viewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        viewModel.getAllCategories();

        viewModel.getCateLiveData().observe(getViewLifecycleOwner(), new Observer<List<CategoriesItem>>() {
            @Override
            public void onChanged(List<CategoriesItem> categoriesItems) {
                adapter.setCategoriesItems(categoriesItems);

            }
        });

        viewModel.getMessageLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });


    }
}