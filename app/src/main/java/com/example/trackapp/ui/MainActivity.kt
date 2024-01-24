package com.example.trackapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trackapp.R
import com.example.trackapp.db.RunDao
import com.example.trackapp.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private lateinit var dataBinding: ActivityMainBinding
    private var navController: NavController? = null
    private lateinit var navHostFragment:NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationToTrackingFragmentIfNeeded(intent)

//        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        dataBinding.lifecycleOwner = this

        navHostFragment= supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController!!)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
        navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, distance, _ ->
                when (distance.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment -> {
                        bottomNavigationView.visibility = View.VISIBLE
                    }

                    else -> {
                        bottomNavigationView.visibility = View.GONE
                    }
                }

            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigationToTrackingFragmentIfNeeded(intent)
    }
    private fun navigationToTrackingFragmentIfNeeded(intent: Intent?){
        if (intent?.action==ACTION_SHOW_TRACKING_FRAGMENT){
            navHostFragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }
}