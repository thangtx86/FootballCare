package com.apps.footballcare.view


import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseActivity
import com.apps.footballcare.databinding.ActivityMainBinding
import com.apps.footballcare.di.injectViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }
    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initView() {
        navController = findNavController(R.id.nav_host_fragment)
        setupBottomNavMenu(navController)


    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottomNav?.setupWithNavController(navController)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}