package com.example.home.Apiservice


import retrofit2.http.GET
import retrofit2.http.Query

interface recommendApiservice{
    @GET("/api/v5/index/tab/allRec")
    suspend fun getrecommendDate(@Query("page")page: Int, @Query("per_page") perPage: Int): rApiResponse
}