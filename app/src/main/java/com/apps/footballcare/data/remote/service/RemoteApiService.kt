package com.apps.footballcare.data.remote.service

import com.apps.footballcare.data.remote.model.League
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
     * The func use for get leagues.
     * Ex: get leagues by seasons 2021
     */
    @GET("/")
    suspend fun getLeagues(@Query("action") league: String): List<League>
}