package com.apps.footballcare.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
import javax.inject.Inject

/**
 *
 * SearchViewModel.kt.
 *
 * Created by thangtx on 11/06/21.
 *
 */
class SearchViewModel @Inject constructor(private val repository: RemoteRepositoryImpl) :
    BaseViewModel() {
    var categoriesDummy = mutableListOf<String>(
        "backgrounds",
        "fashion",
        "nature",
        "science",
        "education",
        "feelings",
        "health",
        "people",
        "religion",
        "places",
        "animals",
        "industry",
        "computer",
        "food",
        "sports",
        "transportation",
        "travel",
        "buildings",
        "business",
        "music"
    )
    private var _categories = MutableLiveData<List<String>>()

    val categories: LiveData<List<String>> = _categories

    init {
        _categories.value = categoriesDummy.toList()
    }


}