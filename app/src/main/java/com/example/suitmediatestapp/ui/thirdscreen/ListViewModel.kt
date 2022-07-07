package com.example.suitmediatestapp.ui.thirdscreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.suitmediatestapp.data.UserRepository
import com.example.suitmediatestapp.di.Injection
import com.example.suitmediatestapp.network.DataItem

class ListViewModel(userRepository: UserRepository) : ViewModel() {

    val user: LiveData<PagingData<DataItem>> =
        userRepository.getUser().cachedIn(viewModelScope)

    class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(Injection.provideRepository(context)) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
