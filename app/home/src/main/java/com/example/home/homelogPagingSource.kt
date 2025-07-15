package com.example.home

import com.example.home.Apiservice.Daily
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

class homelogPagingSource(private val logApiservice: logApiservice) :
    PagingSource<Int, Daily>() {
    override fun getRefreshKey(state: PagingState<Int, Daily>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Daily> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val response = logApiservice.getlogDate(page, pageSize)
            Log.d("Paging", "Loaded page $page, items: ${response.itemList.size}")
            LoadResult.Page(
                data = response.itemList,
                prevKey = null,
                nextKey = if (response.itemList.isEmpty()) null else page + 1
            )
        }catch (e: Exception){
            Log.e("Paging", "Load error", e)
            LoadResult.Error(e)
        }

    }
}