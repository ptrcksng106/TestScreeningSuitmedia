package com.example.suitmediatestapp.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.suitmediatestapp.network.ApiService
import com.example.suitmediatestapp.network.DataItem
import com.example.suitmediatestapp.network.UserResponseItem

class UserRepository(private val apiService: ApiService) {
    fun getUser(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}