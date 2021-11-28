package com.apps.footballcare.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.remote.model.FootballResponse
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * HomeViewModel.kt.
 *
 * Created by thangtx on 11/05/21.
 *
 */
class HomeViewModel @Inject constructor(private val repository: RemoteRepositoryImpl) :
    BaseViewModel() {


}