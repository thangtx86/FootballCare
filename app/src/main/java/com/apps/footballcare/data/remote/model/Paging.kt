package com.apps.footballcare.data.remote.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Paging(
    @SerializedName("current") var current: Int? = null,
    @SerializedName("total") var total: Int? = null
)