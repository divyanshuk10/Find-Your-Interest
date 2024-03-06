package com.divyanshu.findyourinterest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.divyanshu.findyourinterest.model.Interest

@Database(entities = [Interest::class], version = 1)
abstract class InterestDB : RoomDatabase() {
    abstract fun interestDao(): InterestDao
}