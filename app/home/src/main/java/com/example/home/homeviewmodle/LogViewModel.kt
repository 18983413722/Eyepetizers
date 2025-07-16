package com.example.home.homeviewmodle

import com.example.home.Apiservice.Daily
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class logViewModel: ViewModel() {

    fun getPagingData(): Flow<PagingData<Daily>> {
        return homelogRepository.getPagingData().cachedIn(viewModelScope)
    }

}