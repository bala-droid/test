package com.baladroid.baseapp.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.baladroid.baseapp.domain.sharedpref.PreferenceRepository
import com.baladroid.baseapp.R
import com.baladroid.baseapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var navController: NavController
    lateinit var  actionBarDrawerToggle: ActionBarDrawerToggle

    lateinit var preferenceRepository: PreferenceRepository
    private val localViewModel by viewModels<MainViewModel>()

    private lateinit var viewModel: MainViewModel
    fun createViewModel(): MainViewModel {
        return localViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = createViewModel()

        preferenceRepository = PreferenceRepository(applicationContext)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close)


        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
       // actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navController = findNavController(R.id.nav_host_fragment)
        //bottom nav
        binding.bottomNavView.setupWithNavController(navController)
        //drawer
        /*appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboard_fragment,R.id.ministries_fragment,  R.id.carecell_fragment, R.id.about_fragment),
            binding.drawerLayout
        )*/
        //menu item click handle
      //  binding.navView.setupWithNavController(navController)




        //
    //    setupActionBarWithNavController(navController, appBarConfiguration)


        binding.navView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            when(id){
                R.id.dashboard_fragment -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.about_fragment -> {
                    Toast.makeText(this, "About ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.sign_out_fragment -> {
                    Toast.makeText(applicationContext, "Sign Out.", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    true
                }
            }
        }

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.b_menu_1 -> {
                    Toast.makeText(this, "Menu 1 - Bottom Navigation", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.b_menu_2 -> {
                    Toast.makeText(this, "Menu 2 - Bottom Navigation", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.b_menu_3 -> {
                    Toast.makeText(this, "Menu 3 - Bottom Navigation", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.b_menu_4 -> {
                    Toast.makeText(this, "Menu 4 - Bottom Navigation", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    override fun onStart() {
        super.onStart()
    }



    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else {
            return when (item.itemId) {
                R.id.navigation_notification -> {
                    Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    return false
                }
            }

        }
        super.onOptionsItemSelected(item)
    }




    companion object {
        private val TAG = MainActivity::class.java.getSimpleName()
        var mainActivity: MainActivity? = null

        fun getInstance(): MainActivity? = mainActivity

    }
}

