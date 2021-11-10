package com.sharminnipu.navigationdrawerdemo.ui.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sharminnipu.navigationdrawerdemo.R
import kotlinx.android.synthetic.main.activity_medicine.*
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

         setUpTab()
    }

    private fun setUpTab() {
        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TabOneFragment(),"TabOne")
        adapter.addFragment(TabTwoFragment(),"TabTwo")
        adapter.addFragment(TabThreeFragment(),"TabThree")
        viewPager.adapter=adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setText("Order")
        tabLayout.getTabAt(1)!!.setText("On The Way")
        tabLayout.getTabAt(2)!!.setText("Delivery")


    }
}