package com.example.square

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lib.base.BaseFragment
import com.example.square.bean.ChildTabBean
import com.example.square.bean.TabListBean
import com.example.square.databinding.FragmentSquareBinding
import com.example.square.viewmodule.JumpViewModle
import com.example.square.viewmodule.SquareViewModule
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.square.adpter.reAdpter
import com.example.square.adpter.vpAdpter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SquareFragment : BaseFragment<FragmentSquareBinding>() {
    private lateinit var squareViewModule :SquareViewModule
    private lateinit var jumpViewModle: JumpViewModle
    private var tabList :TabListBean? = null
    private  var childList = mutableListOf<ChildTabBean>()
    private val mAdapter : reAdpter by lazy {
        tabList?.let { reAdpter(it,childList) }!!
    }


    override fun getBinding(): FragmentSquareBinding {
        return FragmentSquareBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_square, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        squareViewModule=ViewModelProvider(requireActivity())[SquareViewModule::class.java]
        jumpViewModle=ViewModelProvider(requireActivity())[JumpViewModle::class.java]
        mBinding?.rvCom?.layoutManager=LinearLayoutManager(activity)
    }
    fun getChildData(){
        viewLifecycleOwner.lifecycleScope.launch {
            jumpViewModle.getChildData()
            jumpViewModle.childTabStateFlow.collect{
                it?.let {
                    childList.addAll(it)
                    getTabData()
                }
            }
        }

    }
    fun getTabData(){
        lifecycleScope.launch {
            squareViewModule.getTabData()
            repeatOnLifecycle(Lifecycle.State.STARTED){
                squareViewModule.tabStateFlow.collect{
                   if (it!=null){
                       mBinding?.rvCom?.apply {
                           tabList = it
                           adapter = mAdapter
                       }
                   }
            }

            }
        }


    }
}