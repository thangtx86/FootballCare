package com.apps.footballcare.data.remote.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class League(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("logo") var logo: String? = null
)