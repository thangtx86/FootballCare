package com.apps.footballcare.base.domain.repository

import com.apps.footballcare.data.remote.model.League

/**
 *
 * RemoteRepository.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
interface RemoteRepository {
    suspend fun getLeaguesBySeasons(league: String): List<League>
}