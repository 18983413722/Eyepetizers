package com.example.square.refroit
import com.example.square.api.ChildTabService
import com.example.square.api.TabListService
import com.example.lib.net.MyRetrofit

/**
 *description:能看小说的app
 * author 王以飞
 * email 1206897770@qq.com
 * date 2025-2-18
 */
object Squarere {
    val tabService: TabListService = MyRetrofit.getService(TabListService::class.java)
    val childTabService: ChildTabService = MyRetrofit.getService(ChildTabService::class.java)
}