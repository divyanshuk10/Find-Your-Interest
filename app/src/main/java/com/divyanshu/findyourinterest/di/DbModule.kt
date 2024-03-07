package com.divyanshu.findyourinterest.di

import android.content.Context
import androidx.room.Room
import com.divyanshu.findyourinterest.db.InterestDB
import com.divyanshu.findyourinterest.db.InterestDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun providesDBInstance(@ApplicationContext applicationContext: Context): InterestDB =
        Room.databaseBuilder(
            applicationContext,
            InterestDB::class.java,
            "interest_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideInterestDao(database: InterestDB): InterestDao {
        return database.interestDao()
    }
}