package com.apps.footballcare.di.component

import com.apps.footballcare.FootballCareApp
import com.apps.footballcare.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 *
 * AppComponent.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
@Singleton
@Component(
    modules = [
        ActivityBuilder::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class,
        FragmentModule::class
    ]
)

interface AppComponent : AndroidInjector<FootballCareApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FootballCareApp): Builder

        fun build(): AppComponent
    }

}