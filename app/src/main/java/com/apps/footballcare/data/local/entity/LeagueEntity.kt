package com.apps.footballcare.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *
 * LeagueEntity.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
@Entity
data class LeagueEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "logo") val logo: String?,
)
