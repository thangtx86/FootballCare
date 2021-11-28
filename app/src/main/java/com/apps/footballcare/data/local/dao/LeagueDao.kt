package com.apps.footballcare.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity

/**
 *
 * LeagueDao.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
@Dao
interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLeague(leagueEntity: List<ResponseEntity>)
}