package com.apps.footballcare.view.start

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.footballcare.R
import com.apps.footballcare.base.view.BaseActivity
import com.apps.footballcare.base.viewmodel.EmptyViewModel
import com.apps.footballcare.databinding.ActivityGetStartedBinding
import com.apps.footballcare.di.injectViewModel
import com.apps.footballcare.view.MainActivity

class GetStartedActivity : BaseActivity<ActivityGetStartedBinding, GetStartedViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<GetStartedViewModel> {
        return GetStartedViewModel::class.java
    }

    override fun initView() {

    }


    override fun getLayoutResourceId(): Int = R.layout.activity_get_started

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, GetStartedActivity::class.java))
        }
    }
}