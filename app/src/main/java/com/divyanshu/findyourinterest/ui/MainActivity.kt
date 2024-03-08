package com.divyanshu.findyourinterest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.divyanshu.findyourinterest.R
import com.divyanshu.findyourinterest.databinding.ActivityMainBinding
import com.divyanshu.findyourinterest.viewmodel.FavouriteInterestViewModel
import com.divyanshu.findyourinterest.viewmodel.InterestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel by viewModels<InterestViewModel>()
    private val favouriteInterestViewModel by viewModels<FavouriteInterestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setNavController()
        navigateToInterestScreen()
    }

    private fun navigateToInterestScreen() {
        viewModel.shouldNavigate.observe(this) {
            if (it) {
                binding.bottomNavigation.selectedItemId = R.id.interestsFragment
                //binding.bottomNavigation.menu.findItem(R.id.interestsFragment).setChecked(it)
                viewModel.navigateToInterestsTab(!it)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(this, navController)
    }
}