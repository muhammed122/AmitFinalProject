package com.example.amitfinalproject.data.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("token")
	private String token;

	public String getToken(){
		return token;
	}




}