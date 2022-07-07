package com.example.suitmediatestapp.di

import android.content.Context
import com.example.suitmediatestapp.data.UserRepository
import com.example.suitmediatestapp.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository(apiService)
    }
}