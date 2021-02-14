package com.example.amitfinalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.amitfinalproject.R;
import com.example.amitfinalproject.data.api.ApiManager;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        SharedPreferences shared = getSharedPreferences("token",MODE_PRIVATE);




    }
}