package com.apps.footballcare.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * CountryEntity.kt.
 *
 * Created by thangtx on 11/28/21.
 *
 */
@Entity
data class CountryEntity(
    @PrimaryKey
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "code") val code: String?,
    @ColumnInfo(name = "flag") val flag: String?,
)