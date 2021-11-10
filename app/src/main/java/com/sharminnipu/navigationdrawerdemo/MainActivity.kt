package com.sharminnipu.navigationdrawerdemo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.ViewParent
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sharminnipu.navigationdrawerdemo.ui.account.AccountActivity
import com.sharminnipu.navigationdrawerdemo.utils.AppConstant.fragment_index
import com.sharminnipu.navigationdrawerdemo.utils.StateManagement
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout= findViewById(R.id.drawer_layout)
       navView= findViewById(R.id.nav_view)
       navController = findNavController(R.id.nav_host_fragment)

        navBarDrawer()
        bottomBarMenu()
        sideBarNavigationAction(navView, toolbar)


    }



    //navBar drawer
   private fun navBarDrawer(){

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


       // start drawer menu icon change

       var actionBarDrawer= ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open,
          R.string.close)
       actionBarDrawer.isDrawerIndicatorEnabled = false
       actionBarDrawer.setHomeAsUpIndicator(R.drawable.menu)
       actionBarDrawer.setToolbarNavigationClickListener {

           drawerLayout.openDrawer(GravityCompat.START)
       }

       //end menu icon change
    }

    //sidebar navigation action
    private fun sideBarNavigationAction(navView: NavigationView, toolbar: Toolbar) {

        navView.setNavigationItemSelectedListener { menuItem ->
            val handled =
                NavigationUI.onNavDestinationSelected(menuItem, navController)
            if (handled) {
                val parent: ViewParent = navView.parent
                if (parent is DrawerLayout) {
                    (parent).closeDrawer(navView)
                }
            }
            when (menuItem.itemId) {
                R.id.nav_gallery -> {
                    closeDrawerMenu()
                    fragment_index = StateManagement.GALLERY
                    startActivity(Intent(applicationContext, AccountActivity::class.java))
                }

            }
            handled
        }

    }
    private fun closeDrawerMenu() {
        val parent: ViewParent = navView.parent
        if (parent is DrawerLayout) {
            (parent).closeDrawer(navView)
        }
    }
    //bottomBar Menu
    private fun bottomBarMenu(){
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottom_nav_view.background=null

        bottom_nav_view.menu.setGroupCheckable(0,false,false)
        bottom_nav_view.menu.findItem(R.id.navigation_home).isCheckable=true
        var badge = navView.getOrCreateBadge(R.id.navigation_notification)
        badge.number= 1
      /*  if(countNotification>0){
            var badge = navView.getOrCreateBadge(androidx.navigation.ui.R.id.navigation_notification)
            badge.number= countNotification
        }  */

        // System.out.println(countNotification.toString())
        /* viewModel.notificationListData(1).observe(this, androidx.lifecycle.Observer {
             try {
                 dataListNotification.clear()
                 dataListNotification.addAll(it.data)

                 count=dataListNotification.count { it.reading_status==null }

                 logE("count reading null:",count.toString())
             }
             catch (e:Exception)
             {
                 logE("dsklfjsdfk",e.message.toString())
             }


         })  */
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> findNavController(R.id.nav_host_fragment).navigate(
                    R.id.nav_home)

                R.id.navigation_health -> {
                    fragment_index =StateManagement.GALLERY
                    val intent = Intent(applicationContext, AccountActivity::class.java)
                    //intent.putExtra("fragmentIndex",1)
                    startActivity(intent)
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
    }


   /* menu on home page
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }   */

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}