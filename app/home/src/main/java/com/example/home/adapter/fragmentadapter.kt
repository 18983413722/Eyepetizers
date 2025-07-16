package com.example.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.home.HomeLogFragment
import com.example.home.HomerecommendedFragment

class fragmentadapter(fg: FragmentActivity) : FragmentStateAdapter(fg) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomerecommendedFragment()
            1 -> HomeLogFragment()
            else -> HomerecommendedFragment()
        }
    }
}