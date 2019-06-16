package com.example.navigationdrawersample.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import com.example.navigationdrawersample.R
import com.example.navigationdrawersample.R.id
import com.example.navigationdrawersample.R.layout
import com.example.navigationdrawersample.R.string
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.navigation_activity_main.drawer_layout
import kotlinx.android.synthetic.main.navigation_activity_main.nav_view

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setSupportActionBar(toolbar)

        /*Show icon drawer*/
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            string.navigation_drawer_open,
            string.navigation_drawer_close
        )
        drawer_layout?.addDrawerListener(toggle)
        toggle.syncState()

        // listen icon drawer onclick
        nav_view?.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            id.nav_home -> {
            }
            id.nav_gallery -> {
            }
            id.nav_slideshow -> {
            }
            id.nav_share -> {
            }
            id.nav_send -> {
            }
        }
        val drawerLayout: DrawerLayout = findViewById(id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
