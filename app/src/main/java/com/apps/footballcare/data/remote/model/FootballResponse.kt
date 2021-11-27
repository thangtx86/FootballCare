package com.apps.footballcare.data.remote.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class FootballResponse(
    @SerializedName("get") var get: String? = null,
    @SerializedName("parameters") var parameters: Parameters? = null,
    @SerializedName("errors") var errors: List<String>? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("paging") var paging: Paging? = null,
    @SerializedName("response") var response: List<Response>? = null

)