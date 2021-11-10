package com.sharminnipu.navigationdrawerdemo.ui.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(supportFragmentManager:FragmentManager):FragmentPagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList=ArrayList<Fragment>()
    private val mFragmentTitleList=ArrayList<String>()


    override fun getCount(): Int {

        return mFragmentList.size

    }

    override fun getItem(position: Int): Fragment {

        return mFragmentList[position]

    }

    fun addFragment(fragment: Fragment,title:String){

        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}