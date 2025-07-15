package com.example.square.adpter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.square.R
import com.example.square.bean.ChildTabBean
import com.example.square.bean.Item
import com.example.square.bean.Tab
import com.example.square.bean.TabListBean


/**
 *description:能看小说的app
 * author 王以飞
 * email 1206897770@qq.com
 * date 2025-2-18
 */

class reAdpter(private val tabListBean :TabListBean,private  val child : MutableList<ChildTabBean>) : RecyclerView.Adapter<reAdpter.reViewHolder>() {
    inner class reViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val v :TextView =itemView.findViewById(R.id.tv_name)
        val v2 :ViewPager2 =itemView.findViewById(R.id.vp_com)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): reViewHolder {
        val v : View = LayoutInflater.from(p0.context).inflate(R.layout.item_rv,p0,false)
        return reViewHolder(v)
    }

    override fun getItemCount(): Int {
       return tabListBean.tabInfo.tabList.size
    }

    override fun onBindViewHolder(p0: reViewHolder, p1: Int) {
       val item : Tab = tabListBean.tabInfo.tabList[p1]
        p0.v.text = item.name
       val childitem = child[p1]
        val adapter : vpAdpter = vpAdpter(childitem.itemList as List<Item>)
        p0.v2.adapter = adapter
    }

}