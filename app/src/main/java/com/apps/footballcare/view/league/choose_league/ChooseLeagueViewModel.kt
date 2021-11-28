package com.apps.footballcare.view.league.choose_league

import android.util.Log
import androidx.lifecycle.*
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.local.entity.CountryEntity
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity
import com.apps.footballcare.data.remote.model.Response
import com.apps.footballcare.base.domain.repositoryimpl.LocalRepositoryImpl
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.utils.Event
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * ChooseLeagueViewModel.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class ChooseLeagueViewModel @Inject constructor(
    private val repository: RemoteRepositoryImpl,
    private val localRepositoryImpl: LocalRepositoryImpl
) :
    BaseViewModel() {

    private var _leaguesSelected = mutableListOf<Response>()

    private val _response = MutableLiveData<Resource<List<Response>>>()
    val response: LiveData<Resource<List<Response>>> = _response

    val events: LiveData<Event<String>>
        get() = _events
    private val _events = MutableLiveData<Event<String>>()

    private var listResponseEntity: MutableList<ResponseEntity> = mutableListOf()

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
        viewModelScope.launch(Dispatchers.IO) {
            val list = mutableListOf<ResponseEntity>()
            try {
                withContext(Dispatchers.IO) {
                    val responseEntity = localRepositoryImpl.getAllLeague()
                    withContext(Dispatchers.IO) {
                        if (!responseEntity.isNullOrEmpty()) {
                            localRepositoryImpl.deleteAllLeague()
                        }
                    }
                }
                _leaguesSelected.map { item ->
                    val lear = item.league
                    val country = item.country
                    val leagueEntity = LeagueEntity(lear?.id, lear?.name, lear?.type, lear?.logo)
                    val countryEntity = CountryEntity(country?.name, country?.code, country?.flag)
                    val responseEntity =
                        ResponseEntity(league = leagueEntity, country = countryEntity)
                    list.add(responseEntity)
                }
                localRepositoryImpl.insertLeagues(list)
                _events.postValue(Event(NEXT_ACTION))

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    fun onSkip() {
        _events.postValue(Event(SKIP_ACTION))
    }
}