package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.adapter.homerecommendadapter
import com.example.home.databinding.FragmentHomerecommendedBinding // 自动生成的绑定类
import com.example.home.homeviewmodle.RecommendViewModel
import com.example.home.homeviewmodle.logViewModel
import kotlinx.coroutines.launch

class HomerecommendedFragment : Fragment() {
    private var _binding: FragmentHomerecommendedBinding? = null
    private val binding get() = _binding!!
    private val recommendadapter = homerecommendadapter()

    private val viewModel by lazy { ViewModelProvider(this).get(RecommendViewModel::class.java) }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomerecommendedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rrecyclerview.apply {
            adapter = recommendadapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        lifecycleScope.launch {
            viewModel.getPagingData().collect { rpagingData ->
                recommendadapter.submitData(rpagingData)
            }
        }

    }

    companion object {
        fun newInstance() = HomerecommendedFragment()
        /*
        fun newInstance(param1: String, param2: String) =
            HomerecommendedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }
}