package com.apps.footballcare.base.domain.repository

import com.apps.footballcare.data.local.entity.ResponseEntity
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 *
 * LocalRepository.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
interface LocalRepository {
    suspend fun insertLeagues(leagueEntity: List<ResponseEntity>)
    suspend fun deleteAllLeague()
    suspend fun getAllLeague(): List<ResponseEntity>
}