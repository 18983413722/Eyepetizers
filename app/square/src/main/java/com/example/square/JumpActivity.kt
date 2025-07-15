package com.example.square

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib.base.BaseActivity
import com.example.square.databinding.ActivityJumpBinding

class jumpActivity : BaseActivity<ActivityJumpBinding>() {
    override fun getBinding(): ActivityJumpBinding {
        return ActivityJumpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump)
        }

}
