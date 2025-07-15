package com.example.square.viewmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.square.bean.ChildTabBean
import com.example.square.refroit.Squarere
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *description:能看小说的app
 * author 王以飞
 * email 1206897770@qq.com
 * date 2025-2-18
 */
class JumpViewModle : ViewModel() {
    private var _ChildTabStateFlow = MutableStateFlow<List<ChildTabBean>?>(null)
    val childTabStateFlow : StateFlow<List<ChildTabBean>?>
        get()= _ChildTabStateFlow

    fun getChildData(){
        viewModelScope.launch(Dispatchers.IO) {
            val dateList = Squarere.tabService.getCommunityTab().tabInfo.tabList.map { it.id.toString() }
            val childList = mutableListOf<ChildTabBean>()
            for (id in dateList){
                val response : ChildTabBean = if(id == "-1"){
                    Squarere.childTabService.getChildTab("0","","","")
                }else{
                    Squarere.childTabService.getChildTab(id,"","","")
                }
                childList.add(response)
            }
            _ChildTabStateFlow.emit(childList)
        }
    }
}