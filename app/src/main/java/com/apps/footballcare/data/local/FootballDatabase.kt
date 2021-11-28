package com.apps.footballcare.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.footballcare.data.local.dao.LeagueDao
import com.apps.footballcare.data.local.entity.LeagueEntity
import com.apps.footballcare.data.local.entity.ResponseEntity

/**
 *
 * FootballDatabase.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
@Database(entities = [ResponseEntity::class], version = 2)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun getLeagueDao(): LeagueDao
}