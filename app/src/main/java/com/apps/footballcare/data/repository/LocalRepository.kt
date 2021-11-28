package com.apps.footballcare.data.repository

import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity

/**
 *
 * LocalRepository.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
interface LocalRepository {
    suspend fun addLeague(leagueEntity: List<ResponseEntity>)
}