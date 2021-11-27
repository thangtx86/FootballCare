package com.apps.footballcare.data.repositoryimpl

import com.apps.footballcare.data.remote.model.FootballResponse
import com.apps.footballcare.data.repository.RemoteRepository
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

    override suspend fun getLeaguesBySeasons(seasons: Int): FootballResponse =
        api.getLeaguesBySeasons(seasons)
}