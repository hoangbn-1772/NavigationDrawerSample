package com.example.navigationdrawersample.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigationdrawersample.R
import com.example.navigationdrawersample.R.layout
import com.example.navigationdrawersample.R.string
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.navigation_activity_main.drawer_layout
import kotlinx.android.synthetic.main.navigation_activity_main.nav_view

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setSupportActionBar(toolbar)
        initComponents()

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
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
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
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
            }
            R.id.nav_gallery -> {
            }
            R.id.nav_slideshow -> {
            }
            R.id.nav_share -> {
            }
            R.id.nav_send -> {
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_goto_custom -> {
                Intent(this, MainActivityCustom::class.java).apply {
                    startActivity(this)
                }
            }

            R.id.button_goto_navigation -> {
                Intent(this, MainActivityNavigation::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

    private fun initComponents() {
        button_goto_custom.setOnClickListener(this)
        button_goto_navigation.setOnClickListener(this)
    }
}
