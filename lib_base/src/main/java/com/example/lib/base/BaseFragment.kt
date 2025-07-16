package com.example.lib.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<viewBinding :ViewBinding> : Fragment() {
    protected var mBinding :viewBinding? =getBinding()
    abstract fun getBinding():viewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}
