package com.apps.footballcare.base.domain.repositoryimpl

import com.apps.footballcare.data.local.dao.LeagueDao
import com.apps.footballcare.data.local.entity.ResponseEntity
import com.apps.footballcare.base.domain.repository.LocalRepository
import com.apps.footballcare.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
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

    override suspend fun insertLeagues(leagueEntity: List<ResponseEntity>) =
        dao.insertLeagues(leagueEntity)


    override suspend fun getAllLeague(): List<ResponseEntity> = dao.getAllLeagues()
    override suspend fun deleteAllLeague() = dao.deleteAllLeagues()
}