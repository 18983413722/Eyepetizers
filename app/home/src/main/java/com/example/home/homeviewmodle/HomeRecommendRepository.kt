package com.example.home.homeviewmodle


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.home.Apiservice.Recommend
import com.example.lib_network.RetrofitClient
import kotlinx.coroutines.flow.Flow

object homecommendRepository {

    private const val PAGE_SIZE = 10

    private val recommendApiservice = RetrofitClient.getService(com.example.home.Apiservice.recommendApiservice::class.java)

    fun getPagingData(): Flow<PagingData<Recommend>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { homerecommendPagingSource(recommendApiservice) }
        ).flow
    }

}