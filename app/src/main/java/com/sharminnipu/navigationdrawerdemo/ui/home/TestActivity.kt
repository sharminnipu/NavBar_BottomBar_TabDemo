package com.sharminnipu.navigationdrawerdemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sharminnipu.navigationdrawerdemo.R

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}