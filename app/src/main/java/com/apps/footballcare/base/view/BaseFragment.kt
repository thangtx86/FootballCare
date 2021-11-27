package com.apps.footballcare.base.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.apps.footballcare.R
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.extensions.orFalse
import com.apps.footballcare.extensions.runContextNotNull
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * BaseFragment.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    private var hasRequestSend = false
    private var progressDialog: Dialog? = null

    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    protected abstract val classTypeOfViewModel: Class<VM>
    open val nestedNavHostFragmentId: Int? = null
    open val navGraphId: Int? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var binding: DB
    lateinit var viewModel: VM
    var navController: NavController? = null

    @SuppressLint("BinaryOperationInTimber")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("$TAG: --- " + this.javaClass.simpleName + ": ----  onViewCreate")
        initView()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("$TAG: --- " + this.javaClass.simpleName + ": ---- onCreate")
        viewModel = ViewModelProvider(this, viewModelFactory).get(classTypeOfViewModel)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
//        Timber.e("ThangTX4: --- "+this.javaClass.simpleName+": ---- onCreateView")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        Timber.e("ThangTX4: --- "+this.javaClass.simpleName+": ---- onActivityCreate")
        arguments?.let {
            viewModel.handleIntent(it)
        }

        setUpViewModelStateObservers()
        setupClickListeners()

        if (!hasRequestSend) {
            initStartRequest()
            hasRequestSend = true
        }

        viewModel.firstOpen = false
    }


    open fun initStartRequest() {}
    open fun initView() {}
    open fun setUpViewModelStateObservers() {}
    open fun setupClickListeners() {}

    fun runOnlyFirstInit(block: () -> Unit) {
        if (viewModel.firstOpen) block()
    }


//        fun showSnackBar(targetView: View = requireView().findViewById(R.id.coordinatorLayout), message: String, type: SnackBarType) {
//        val color = when (type) {
//            SUCCESS -> android.R.color.holo_green_dark
//            ERROR -> android.R.color.holo_orange_dark
//        }
//        Snackbar.make(targetView, message, Snackbar.LENGTH_LONG).apply {
//            setBackgroundTint(ContextCompat.getColor(requireContext(), color))
//            setAction("Close") { dismiss() }
//        }.show()
//    }

    fun showProgress() {
        if (progressDialog == null) {
            runContextNotNull {
                progressDialog = Dialog(it).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(false)
                    setContentView(R.layout.layout_loading_white)
                    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                }
            }
        }

        if (!progressDialog?.isShowing.orFalse()) {
            progressDialog?.show()
        }
    }

    //
    fun dismissProgress() {
        if (progressDialog?.isShowing.orFalse()) {
            progressDialog?.dismiss()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Timber.e("$TAG --- " + this.javaClass.simpleName + ": ---- onDestroy")
    }

    override fun onDestroyView() {

        super.onDestroyView()
        Timber.e("$TAG --- " + this.javaClass.simpleName + ": ---- onDestroyView")
    }

    companion object {
        val TAG: String = BaseFragment::class.java.simpleName
    }
}