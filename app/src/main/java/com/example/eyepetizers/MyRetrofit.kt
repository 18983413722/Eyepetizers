package com.example.eyepetizers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
/**
 *description:能看小说的app
 * author 王以飞
 * email 1206897770@qq.com
 * date 2025-2-18
 */
object MyRetrofit {
    private val retrofit : Retrofit.Builder =Retrofit.Builder()
        .baseUrl("https://baobab.kaiyanapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

    fun <T> getService(service :Class<T>):T{
        return retrofit.build().create(service)
    }
}