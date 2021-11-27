package com.apps.footballcare.di.module

import android.app.Application
import android.content.Context
import com.apps.footballcare.FootballCareApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * AppModule.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: FootballCareApp): Context = app

    @Provides
    @Singleton
    fun provideApplication(app: FootballCareApp): Application = app



}