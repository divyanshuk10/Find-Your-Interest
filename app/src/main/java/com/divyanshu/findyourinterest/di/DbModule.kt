package com.divyanshu.findyourinterest.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.divyanshu.findyourinterest.db.InterestDB
import com.divyanshu.findyourinterest.db.InterestDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    private const val TAG = "interest_db"

    @Provides
    @Singleton
    fun providesDBInstance(@ApplicationContext applicationContext: Context): InterestDB =
        Room.databaseBuilder(
            applicationContext, InterestDB::class.java, "interest_db"
        ).fallbackToDestructiveMigration().setQueryCallback({ query, args ->
            // For logging purpose
            Log.d(TAG, "interest_db -> $query SQL Args: $args")
        }, executor = Executors.newSingleThreadExecutor()).build()

    @Provides
    @Singleton
    fun provideInterestDao(database: InterestDB): InterestDao {
        return database.interestDao()
    }
}