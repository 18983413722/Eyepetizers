package com.example.square.api
import com.example.square.bean.ChildTabBean
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChildTabService {
    @GET("api/v7/tag/childTab/{id}")
    suspend fun getChildTab(
        @Path("id") id: String,
        @Query("isRecTab") isRecTab: String,
        @Query("start") start: String,
        @Query("num") num: String
    ): ChildTabBean
}