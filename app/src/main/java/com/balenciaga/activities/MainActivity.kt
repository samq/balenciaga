package com.balenciaga.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.forEach
import com.balenciaga.R
import com.balenciaga.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var toolbar : androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar - Sets up Toolbar to be AppBar for the Activity
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Title - Uppercase App Name
        title = resources.getString(R.string.app_name).toUpperCase(Locale.ROOT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        hideToolbarIcons()
        return true
    }

    // Toolbar - MenuItem selected - Handles what happen when icon clicked on in the toolbar.
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        // Cart/Bag
        R.id.action_cart -> {
            true
        }
        // Customer Service
        R.id.action_customer_service -> {
            true
        }
        // Menu
        R.id.action_menu -> {
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // Hides Toolbar Icons
    fun hideToolbarIcons() {
        toolbar.menu.forEach { item -> item.isVisible = false }
    }
    // Unhides Toolbar Icons
    fun unhideToolbarIcons() {
        toolbar.menu.forEach { item -> item.isVisible = true }
    }
}