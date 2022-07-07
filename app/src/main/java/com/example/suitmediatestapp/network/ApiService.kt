package com.example.suitmediatestapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUser(
        @Query("page") page: Int,
        @Query("per_page") size: Int
    ): ListUserResponseItem
}