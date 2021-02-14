package com.example.amitfinalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.helper.TokenManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;

    TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavWithBottomNav();


        Toast.makeText(this, "my test branch", Toast.LENGTH_SHORT).show();



        tokenManager = new TokenManager(this);
       String s= tokenManager.getToken();
        Log.d("ddddddddddddd", "onCreate: "+s);
    }

    protected void setupNavWithBottomNav(){
        bottomNavigationView=findViewById(R.id.my_bottom_nav);
        navController=Navigation.findNavController(this,R.id.my_nav_host);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }


}