package com.example.square.api
import com.example.square.bean.TabListBean
import retrofit2.http.GET

interface TabListService {
    @GET("api/v7/tag/tabList")
    suspend fun getCommunityTab(): TabListBean
}