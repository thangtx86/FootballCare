package com.apps.footballcare.view

import androidx.lifecycle.ViewModel
import com.apps.footballcare.data.repositoryimpl.RemoteRepositoryImpl
import javax.inject.Inject

/**
 *
 * MainViewModel.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
class MainViewModel @Inject constructor(private val repository: RemoteRepositoryImpl) :
    ViewModel() {
}