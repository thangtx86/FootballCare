package com.apps.footballcare.base.domain.repository

import com.apps.footballcare.data.remote.model.FootballResponse

/**
 *
 * RemoteRepository.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
interface RemoteRepository {
    suspend fun getLeaguesBySeasons(seasons: Int): FootballResponse
}