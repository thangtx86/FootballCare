package com.apps.footballcare.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 *
 * League.kt.
 *
 * Created by thangtx on 11/30/21.
 *
 */
data class League(

    @SerializedName("country_id") var countryId: String? = null,
    @SerializedName("country_name") var countryName: String? = null,
    @SerializedName("league_id") var leagueId: String? = null,
    @SerializedName("league_name") var leagueName: String? = null,
    @SerializedName("league_season") var leagueSeason: String? = null,
    @SerializedName("league_logo") var leagueLogo: String? = null,
    @SerializedName("country_logo") var countryLogo: String? = null,
    var isSelected: Boolean = false

)