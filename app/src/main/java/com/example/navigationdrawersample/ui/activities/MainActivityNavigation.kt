package com.example.navigationdrawersample.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.navigationdrawersample.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import kotlinx.android.synthetic.main.navigation_activity_main.*

class MainActivityNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        /*show icon menu navigation drawer*/
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
        /*setup NavigationView*/
        NavigationUI.setupWithNavController(navigationView, navController)

        // Can use setNavigationItemSelectedListener for navigationView
        // Use navController for transaction destination.
    }

    /*Handle click Navigation button*/
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawer_layout)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
