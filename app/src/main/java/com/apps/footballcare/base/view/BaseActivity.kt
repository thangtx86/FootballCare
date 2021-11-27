package com.apps.footballcare.base.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.apps.footballcare.R
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * BaseActivity.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mViewDataBinding: VB
    lateinit var mViewModel: VM

    protected lateinit var navController: NavController

    val binding: VB get() = mViewDataBinding
    val viewModel: VM get() = mViewModel


    abstract fun injectViewModel()
    abstract fun getViewModelClass(): Class<VM>
    abstract fun initView()

    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectViewModel()
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutResourceId())
        initView()
        listenBackStackChange()
    }

    fun findNavController(viewId: Int = R.id.nav_host_fragment): NavController {
        val host = (supportFragmentManager
            .findFragmentById(viewId) as NavHostFragment?)!!
        return host.navController
    }

    private fun listenBackStackChange() {
        // Get NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        // ChildFragmentManager of NavHostFragment
        val navHostChildFragmentManager = navHostFragment?.childFragmentManager

        navHostChildFragmentManager?.addOnBackStackChangedListener {

            val backStackEntryCount = navHostChildFragmentManager.backStackEntryCount
            val fragments = navHostChildFragmentManager.fragments
            val fragmentCount = fragments.size

            Timber.e("BackStack: Main graph backStackEntryCount: $backStackEntryCount, fragmentCount: $fragmentCount, fragments: $fragments")

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}