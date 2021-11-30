package com.apps.footballcare.base.domain.repositoryimpl

import com.apps.footballcare.base.domain.repository.RemoteRepository
import com.apps.footballcare.data.remote.model.League
import com.apps.footballcare.data.remote.service.RemoteApiService
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * RemoveRepository.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
@Singleton
class RemoteRepositoryImpl @Inject constructor(private val api: RemoteApiService) :
    RemoteRepository {

    override suspend fun getLeaguesBySeasons(league: String): List<League> =
        api.getLeagues(league)
}