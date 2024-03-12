package com.divyanshu.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.divyanshu.database.dao.InterestDao
import com.divyanshu.database.model.InterestEntity

@Database(
    entities = [
        InterestEntity::class,
    ],
    version = 1,
    autoMigrations = [

    ],
    exportSchema = true,
)
abstract class FYIDatabase : RoomDatabase() {
    abstract fun interestDao(): InterestDao
}