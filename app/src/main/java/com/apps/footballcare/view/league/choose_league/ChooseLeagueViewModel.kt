package com.apps.footballcare.view.league.choose_league

import androidx.lifecycle.*
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.data.local.entity.CountryEntity
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity
import com.apps.footballcare.base.domain.repositoryimpl.LocalRepositoryImpl
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.data.remote.model.League
import com.apps.footballcare.utils.Contains.EMPTY
import com.apps.footballcare.utils.Event
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 *
 * ChooseLeagueViewModel.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class ChooseLeagueViewModel @Inject constructor(
    private val api: RemoteRepositoryImpl,
    private val database: LocalRepositoryImpl
) :
    BaseViewModel() {

    private var _leaguesSelected = mutableListOf<League>()

    val events: LiveData<Event<String>>
        get() = _events
    private val _events = MutableLiveData<Event<String>>()

    private val _response = MutableLiveData<Resource<List<League>>>()
    val response: LiveData<Resource<List<League>>> = _response
    var mResponseList = mutableListOf<League>()

    var searchQuery: String = EMPTY
        set(value) {
            field = value
            onFilterLeague(value)
        }

    fun getLeaguesBySeasons() {

        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(Resource.loading(null))
            try {
                val response = api.getLeaguesBySeasons("get_leagues")
                if (mResponseList.isNotEmpty()) {
                    mResponseList.clear()
                }
                response?.let {
                    mResponseList.addAll(response)
                    _response.postValue(Resource.success(it))

                }

            } catch (e: Exception) {
                e.printStackTrace()
                _response.postValue(Resource.error(e.toString(), null))
            }

        }
    }

    private fun onFilterLeague(query: String) {
        val result = if (query.isNotEmpty()) {
            mResponseList.filter { item ->
                item.leagueName!!.contains(query)
            }
        } else {
            mResponseList
        }
        _response.postValue(Resource.success(result))
    }


    fun onLeagueItemSelected(it: List<League>) {
        if (_leaguesSelected.isNotEmpty()) {
            _leaguesSelected.clear()
        }
        _leaguesSelected.addAll(it)
    }

    fun onNext() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = mutableListOf<ResponseEntity>()
            try {
                checkExistDb()
//                _leaguesSelected.map { item ->
//                    val lear = item.league
//                    val country = item.country
//                    val leagueEntity = LeagueEntity(lear?.id, lear?.name, lear?.type, lear?.logo)
//                    val countryEntity = CountryEntity(country?.name, country?.code, country?.flag)
//                    val responseEntity =
//                        ResponseEntity(league = leagueEntity, country = countryEntity)
//                    list.add(responseEntity)
//                }
//                database.insertLeagues(list)
                _events.postValue(Event(NEXT_ACTION))

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    private suspend fun onDeleteLeagueDB() = withContext(Dispatchers.IO) {
        database.deleteAllLeague()
    }

    private suspend fun checkExistDb() = withContext(Dispatchers.IO) {
        val responseEntity = getLeaguesFromDb()
        if (!responseEntity.isNullOrEmpty()) {
            onDeleteLeagueDB()
        }
    }

    private suspend fun getLeaguesFromDb(): List<ResponseEntity> {
        return database.getAllLeague()
    }

    fun onSkip() {
        _events.postValue(Event(SKIP_ACTION))
    }
}