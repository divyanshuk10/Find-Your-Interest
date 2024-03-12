package com.divyanshu.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.divyanshu.database.model.InterestEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface InterestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInterest(interest: InterestEntity)

    @Query("SELECT * FROM interests ORDER BY id DESC")
    fun getAllFavouriteInterests(): Flow<List<InterestEntity>>

    @Delete
    suspend fun deleteInterest(interest: InterestEntity)

}