package com.sharminnipu.navigationdrawerdemo.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import com.sharminnipu.navigationdrawerdemo.R
import com.sharminnipu.navigationdrawerdemo.utils.AppConstant.fragment_index
import com.sharminnipu.navigationdrawerdemo.utils.StateManagement

class AccountActivity : AppCompatActivity() {


    private lateinit var navController : NavController
    private lateinit var navGraph : NavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        navController = findNavController(R.id.profile_nav_host_fragment)
        navGraph=navController.graph
        stateManagement(fragment_index)
    }

    private fun stateManagement(index: StateManagement) {
        when (index) {
            StateManagement.GALLERY -> {
                //  tvTitle.text=resources.getString(R.string.article)
                navGraph.startDestination = R.id.galleryFragment
                navController.graph = navGraph
            }

        }
    }


}