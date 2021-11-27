package com.apps.footballcare.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apps.footballcare.base.domain.ImageType
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.remote.model.FootballResponse
import com.apps.footballcare.data.repositoryimpl.RemoteRepositoryImpl
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

    private val _hits = MutableLiveData<Resource<FootballResponse>>()

    val hits: LiveData<Resource<FootballResponse>> = _hits

    private var _imageType = MutableLiveData<String>(ImageType.ALL.name)
    val imageType: LiveData<String>
        get() = _imageType


    fun getLeaguesBySeasons() {
        viewModelScope.launch {
            _hits.postValue(Resource.loading(null))
            try {
                delay(1000L)
                val response = repository.getLeaguesBySeasons(2021)
                _hits.postValue(Resource.success(response))
            } catch (e: Exception) {
                e.printStackTrace()
                _hits.postValue(Resource.error(e.toString(), null))
            }

        }

    }


}