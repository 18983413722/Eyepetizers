package com.example.home.homeviewmodle

import com.example.home.Apiservice.Daily
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.lib_network.RetrofitClient
import kotlinx.coroutines.flow.Flow

object homelogRepository {

    private const val PAGE_SIZE = 10

    private val logApiservice = RetrofitClient.getService(com.example.home.Apiservice.logApiservice::class.java)

    fun getPagingData(): Flow<PagingData<Daily>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { homelogPagingSource(logApiservice) }
        ).flow
    }

}