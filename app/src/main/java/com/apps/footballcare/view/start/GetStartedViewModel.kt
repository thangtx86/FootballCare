package com.apps.footballcare.view.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apps.footballcare.base.domain.repositoryimpl.LocalRepositoryImpl
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 *
 * GetStartedViewModel.kt.
 *
 * Created by thangtx on 11/28/21.
 *
 */
class GetStartedViewModel @Inject constructor(
    private val api: RemoteRepositoryImpl,
    private val db: LocalRepositoryImpl
) : BaseViewModel() {

    val events: LiveData<Event<String>>
        get() = _events
    private val _events = MutableLiveData<Event<String>>()



    private fun getLeagueFromDB() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var leagueFromDB = db.getAllLeague()
                if (!leagueFromDB.isNullOrEmpty()) {
                    _events.postValue(Event("SS"))
                } else {
                    _events.postValue((Event("BB")))
                }
            }


        }

    }
}