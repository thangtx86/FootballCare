package com.apps.footballcare.data.local.dao

import androidx.room.*
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity
import kotlinx.coroutines.flow.Flow

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
    suspend fun insertLeagues(leagueEntity: List<ResponseEntity>)

    @Query("DELETE FROM tbl_league")
    suspend fun deleteAllLeagues()

    @Query("SELECT * FROM tbl_league")
     fun getAllLeagues(): List<ResponseEntity>
}