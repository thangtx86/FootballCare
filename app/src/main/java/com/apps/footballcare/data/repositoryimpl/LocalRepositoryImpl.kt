package com.apps.footballcare.data.repositoryimpl

import com.apps.footballcare.data.local.dao.LeagueDao
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity
import com.apps.footballcare.data.repository.LocalRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * LocalRepositoryImpl.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
@Singleton
class LocalRepositoryImpl @Inject constructor(private val dao: LeagueDao) : LocalRepository {
    override suspend fun addLeague(leagueEntity: List<ResponseEntity>) =
        dao.addLeague(leagueEntity)
}