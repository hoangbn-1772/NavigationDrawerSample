package com.example.navigationdrawersample.ui.activities

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawersample.R
import com.example.navigationdrawersample.R.drawable
import com.example.navigationdrawersample.R.id
import com.example.navigationdrawersample.R.layout
import com.example.navigationdrawersample.R.string
import com.example.navigationdrawersample.custom.NavigationAdapter
import com.example.navigationdrawersample.data.model.ItemNavigation
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.custom_activity_main.drawer_layout
import kotlinx.android.synthetic.main.custom_activity_main.recycler_view_custom
import kotlinx.android.synthetic.main.custom_content_main.content
import kotlinx.android.synthetic.main.navigation_activity_main.nav_view

class MainActivityCustom : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.custom_activity_main)
        setSupportActionBar(toolbar)

        /*Show icon drawer*/
        val toggle = object : ActionBarDrawerToggle(
            this, drawer_layout,
            toolbar,
            string.navigation_drawer_open,
            string.navigation_drawer_close
        ) {
            /*Move content to side in Drawer Layout Android*/
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val scaleFactor = 6f
                /*move content*/
                content.translationX = drawerView.width * slideOffset
                /*Scale content*/
                content.scaleX = 1 - slideOffset.div(scaleFactor)
                content.scaleY = 1 - slideOffset.div(8f)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerStateChanged(newState: Int) {
                super.onDrawerStateChanged(newState)
            }
        }
        // remove Scrim
        drawer_layout?.setScrimColor(Color.TRANSPARENT)
        // remove shadow
        drawer_layout.drawerElevation = 0f
        drawer_layout?.addDrawerListener(toggle)
        toggle.syncState()

        setupNavigationView()

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

    /*Display navigation view custom*/
    private fun setupNavigationView() {
        val adapterCustom = NavigationAdapter(initNavigationData()) { item -> onItemClick(item) }
        recycler_view_custom?.run {
            layoutManager = LinearLayoutManager(this@MainActivityCustom, RecyclerView.VERTICAL, false)
            adapter = adapterCustom
        }
    }

    // Create fake data
    private fun initNavigationData(): List<ItemNavigation> {
        val items: MutableList<ItemNavigation> = arrayListOf()
        items.add(
            ItemNavigation(
                drawable.ic_menu_camera,
                resources.getString(string.menu_home),
                resources.getString(string.menu_home_des)
            )
        )

        items.add(
            ItemNavigation(
                drawable.ic_menu_gallery,
                resources.getString(string.menu_gallery),
                resources.getString(string.menu_gallery_des)
            )
        )
        return items
    }

    /*Handle navigation view item custom clicks here.*/
    private fun onItemClick(item: ItemNavigation) {
        Toast.makeText(this, item.label, Toast.LENGTH_SHORT).show()
        drawer_layout?.closeDrawer(GravityCompat.START)
    }
}
