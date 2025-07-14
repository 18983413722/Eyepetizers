package com.example.eyepetizers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.eyepetizers.databinding.ActivityMainBinding
import com.example.found.FoundFragment
import com.example.home.HomeFragment
import com.example.popular.PopularFragment
import com.example.square.SquareFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var list: List<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        list = listOf(
            HomeFragment(),
            SquareFragment(),
            FoundFragment(),
            PopularFragment()
        )
        startFragment(list.get(0))
        binding.navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.one ->{
                    startFragment(list.get(0))
                    true}
                R.id.two ->{
                    startFragment(list.get(1))
                    true}
                R.id.three ->{
                    startFragment(list.get(2))
                    true}
                R.id.four ->{
                    startFragment(list.get(3))
                    true}

                else -> false
            }
        }
    }

    fun startFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}