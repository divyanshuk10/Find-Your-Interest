package com.divyanshu.findyourinterest.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.divyanshu.findyourinterest.model.Interest
import kotlinx.coroutines.flow.Flow

@Dao
interface InterestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInterest(interest: Interest)

    @Delete
    suspend fun deleteInterest(interest: Interest)

    @Query("SELECT * FROM interest_table ORDER BY id DESC")
    fun getAllFavouriteInterests(): Flow<List<Interest>>
}