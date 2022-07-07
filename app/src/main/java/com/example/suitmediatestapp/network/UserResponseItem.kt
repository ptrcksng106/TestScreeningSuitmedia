package com.example.suitmediatestapp.network

import com.google.gson.annotations.SerializedName

data class UserResponseItem(
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("first_name")
    val first_name: String,
    @field:SerializedName("last_name")
    val last_name: String,
    @field:SerializedName("avatar")
    val avatar: String
)
