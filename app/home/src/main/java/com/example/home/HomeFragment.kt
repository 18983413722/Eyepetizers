package com.example.home

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.home.adapter.fragmentadapter
import com.example.home.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initbp2()
        }

    fun initbp2(){
        binding.viewPager.adapter= fragmentadapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "推荐"
                else -> "日报"
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/*startFragment(fragmentList[0])

        val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener(){

            val distancemax = 100
            override fun onDown(e: MotionEvent): Boolean {
                return true
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                val dx = (e1?.x ?: return false) -e2.x
                val dy = (e1?.y ?:return false)- e2.y
                val lxl = abs(dx)
                Log.d("datasroll", "{ $dx }")
                val lyl = abs(dy)
                if(lxl > lyl&&lxl > distancemax ){
                    if(dx > 0){
                        replaceFragment(true)
                    }else{
                        replaceFragment(false)
                    }
                }
                return false
            }
        })
        binding.homeFrameLayout.setOnTouchListener { _, event ->
                gestureDetector.onTouchEvent(event)
            true
            }
            fun replaceFragment(x: Boolean) {
        if (x) {
            if (currentIndex < fragmentList.size - 1) {
                currentIndex++
            } else {
                return
            }
        } else {
            if (currentIndex > 0) {
                currentIndex--
            } else {
                return
            }
        }

        val currentFragment = fragmentList[currentIndex]
        childFragmentManager.beginTransaction()
            .replace(R.id.homeFrameLayout, currentFragment as Fragment)
            .commit()
    }

    fun startFragment(fragment: Fragment){
        childFragmentManager.beginTransaction()
            .replace(R.id.homeFrameLayout, fragment)
            .commit()
    }
 */