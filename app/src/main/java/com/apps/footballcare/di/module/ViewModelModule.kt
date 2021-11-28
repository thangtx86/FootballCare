package com.apps.footballcare.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.footballcare.base.viewmodel.EmptyViewModel
import com.apps.footballcare.di.ViewModelKey
import com.apps.footballcare.di.factory.ViewModelFactory
import com.apps.footballcare.view.MainViewModel
import com.apps.footballcare.view.home.HomeViewModel
import com.apps.footballcare.view.league.choose_league.ChooseLeagueViewModel
import com.apps.footballcare.view.search.SearchViewModel
import com.apps.footballcare.view.settings.SettingsViewModel
import com.apps.footballcare.view.teams.ChooseTeamsViewModel
import com.apps.footballcare.view.video.VideoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * ViewModelModule.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EmptyViewModel::class)
    internal abstract fun providesEmptyViewModel(viewModel: EmptyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun providesMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun providesHomeViewModel(viewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(VideoViewModel::class)
    internal abstract fun providesVideoViewModel(viewModel: VideoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun providesSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    internal abstract fun providesSettingsViewModel(viewModel: SettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChooseLeagueViewModel::class)
    internal abstract fun providesChooseLeagueViewModel(viewModel: ChooseLeagueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChooseTeamsViewModel::class)
    internal abstract fun providesChooseTeamsViewModel(viewModel: ChooseTeamsViewModel): ViewModel


}