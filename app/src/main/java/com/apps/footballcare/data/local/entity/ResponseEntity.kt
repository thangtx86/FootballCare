package com.apps.footballcare.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * ResponseEntity.kt.
 *
 * Created by thangtx on 11/28/21.
 *
 */
@Entity(tableName = "tbl_league")
data class ResponseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int ?=null,
//    @ColumnInfo(name = "league")
    @Embedded(prefix = "league_by_") var league: LeagueEntity,
//    @ColumnInfo(name = "country")
    @Embedded(prefix = "country_by_") var country: CountryEntity
)
