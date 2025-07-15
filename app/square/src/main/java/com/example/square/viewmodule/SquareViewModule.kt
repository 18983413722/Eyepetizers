package com.example.square.viewmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.square.bean.TabListBean
import com.example.square.refroit.Squarere
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 *description:能看小说的app
 * author 王以飞
 * email 1206897770@qq.com
 * date 2025-2-18
 */
class SquareViewModule : ViewModel() {
    private var _TabStateFlow = MutableStateFlow<TabListBean?>(null)
    val tabStateFlow : StateFlow<TabListBean?>
        get() = _TabStateFlow.asStateFlow()
    fun getTabData()  {
        viewModelScope.launch (Dispatchers.IO){
            val response = Squarere.tabService.getCommunityTab()
            _TabStateFlow.emit(response)
        }
    }
}