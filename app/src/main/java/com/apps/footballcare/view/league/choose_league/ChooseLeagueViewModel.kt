package com.apps.footballcare.view.league.choose_league

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apps.footballcare.base.domain.ImageType
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.remote.model.FootballResponse
import com.apps.footballcare.data.remote.model.Response
import com.apps.footballcare.data.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * ChooseLeagueViewModel.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class ChooseLeagueViewModel @Inject constructor(private val repository: RemoteRepositoryImpl) :
    BaseViewModel() {
    private val _response = MutableLiveData<Resource<List<Response>>>()

    val response: LiveData<Resource<List<Response>>> = _response


    fun getLeaguesBySeasons() {
        viewModelScope.launch {
            _response.postValue(Resource.loading(null))
            try {
                val response = repository.getLeaguesBySeasons(2021)
                val list = response.response
                list?.let {
                    _response.postValue(Resource.success(it))
                }

            } catch (e: Exception) {
                e.printStackTrace()
                _response.postValue(Resource.error(e.toString(), null))
            }

        }

    }
}