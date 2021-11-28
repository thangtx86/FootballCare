package com.apps.footballcare.di.module

import com.apps.footballcare.view.home.HomeFragment
import com.apps.footballcare.view.league.choose_league.ChooseLeagueFragment
import com.apps.footballcare.view.search.SearchFragment
import com.apps.footballcare.view.settings.SettingsFragment
import com.apps.footballcare.view.teams.ChooseTeamsFragment
import com.apps.footballcare.view.video.VideoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * FragmentModule.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesVideoFragment(): VideoFragment

    @ContributesAndroidInjector
    abstract fun contributesSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributesSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun contributesChooseLeagueFragment(): ChooseLeagueFragment

    @ContributesAndroidInjector
    abstract fun contributesChooseTeamsFragment(): ChooseTeamsFragment


}