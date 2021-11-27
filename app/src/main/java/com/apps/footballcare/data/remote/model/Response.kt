package com.apps.footballcare.data.remote.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Response(
    @SerializedName("league") var league: League? = null,
    @SerializedName("country") var country: Country? = null,
    @SerializedName("seasons") var seasons: List<Seasons>? = null,
    var isSelect: Boolean = false
)