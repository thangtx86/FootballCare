package com.apps.footballcare.view.home

import com.apps.footballcare.base.viewmodel.BaseViewModel
import com.apps.footballcare.base.domain.repositoryimpl.RemoteRepositoryImpl
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