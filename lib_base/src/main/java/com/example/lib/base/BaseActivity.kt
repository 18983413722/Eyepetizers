package com.example.lib.base

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

abstract class BaseActivity<viewBinding:ViewBinding> : AppCompatActivity() {
    val mBinding :viewBinding by lazy {
        getBinding()
    }
    abstract fun getBinding() : viewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setContentView(mBinding.root)

    }
}