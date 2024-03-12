package com.divyanshu.database

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.divyanshu.model.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val TAG = "interest_db"

    @Provides
    @Singleton
    fun providesFYIDatabase(
        @ApplicationContext context: Context
    ): FYIDatabase = Room.databaseBuilder(context, FYIDatabase::class.java, "fyi-database")
        .setQueryCallback({ query, args ->
            if (BuildConfig.DEBUG) {
                // For debugging purpose
                Log.d(TAG, "interest_db -> $query SQL Args: $args")
            }
        }, executor = Executors.newSingleThreadExecutor()).build()

}