package com.apps.footballcare.view.league.choose_league

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.remote.model.Response
import com.apps.footballcare.data.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.utils.Event
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.launch
import timber.log.Timber
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

    private var _leaguesSelected = mutableListOf<Response>()

    private val _response = MutableLiveData<Resource<List<Response>>>()
    val response: LiveData<Resource<List<Response>>> = _response

    val events: LiveData<Event<List<Response>>>
        get() = _events
    private val _events = MutableLiveData<Event<List<Response>>>()

    init {
        getLeaguesBySeasons()
    }

    private fun getLeaguesBySeasons() {
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

    fun onLeagueItemSelected(it: List<Response>) {
        if (_leaguesSelected.isNotEmpty()) {
            _leaguesSelected.clear()
        }
        _leaguesSelected.addAll(it)
    }

    fun onNext() {
        Timber.e("sssssssssssss")
    }
}