package com.example.home.Apiservice


import retrofit2.http.GET
import retrofit2.http.Query

interface logApiservice{
    @GET("/api/v5/index/tab/feed")
    suspend fun getlogDate(@Query("page")page: Int, @Query("per_page") perPage: Int): ApiResponse
}

