package com.sharminnipu.navigationdrawerdemo.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sharminnipu.navigationdrawerdemo.R
import kotlinx.android.synthetic.main.activity_tab.*


class TabFRagment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_f_ragment, container, false)
    }


}