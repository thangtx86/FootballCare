package com.apps.footballcare.data.remote.service

import com.apps.footballcare.data.remote.model.FootballResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * RemoteApiService.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
interface RemoteApiService {
    /**
     * The func use for get leagues by seasons.
     * Ex: get leagues by seasons 2021
     */
    @GET("/leagues")
    suspend fun getLeaguesBySeasons(@Query("season") season: Int): FootballResponse
}