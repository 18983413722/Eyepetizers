package com.example.home.homeviewmodle


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.home.Apiservice.Recommend
import kotlinx.coroutines.flow.Flow

class RecommendViewModel : ViewModel(){

    fun getPagingData(): Flow<PagingData<Recommend>> {
        return homecommendRepository.getPagingData().cachedIn(viewModelScope)
    }
}