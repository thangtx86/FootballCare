package com.apps.footballcare.di.module

import com.apps.footballcare.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * ActivityBuilder.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}