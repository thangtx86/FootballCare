package com.apps.footballcare.di.module

import android.content.Context
import androidx.room.Room
import com.apps.footballcare.data.local.FootballDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * LocalDataModule.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(context: Context): FootballDatabase =
        Room.databaseBuilder(context, FootballDatabase::class.java, "local_database")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideFavoritePhotoDao(db: FootballDatabase) = db.getLeagueDao()
}