package com.apps.footballcare.base.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

/**
 *
 * BaseViewModel.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
abstract class BaseViewModel:ViewModel() {
    open fun handleIntent(extras: Bundle) {}
    var firstOpen = true

    suspend inline fun <T> Flow<T>.sendRequest(crossinline onComplete: (T) -> Unit) {
        onEach { data -> onComplete(data) }.collect()
    }
}