package com.apps.footballcare.data.remote.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Coverage(
    @SerializedName("fixtures") var fixtures: Fixtures? = null,
    @SerializedName("standings") var standings: Boolean? = null,
    @SerializedName("players") var players: Boolean? = null,
    @SerializedName("top_scorers") var topScorers: Boolean? = null,
    @SerializedName("top_assists") var topAssists: Boolean? = null,
    @SerializedName("top_cards") var topCards: Boolean? = null,
    @SerializedName("injuries") var injuries: Boolean? = null,
    @SerializedName("predictions") var predictions: Boolean? = null,
    @SerializedName("odds") var odds: Boolean? = null
)