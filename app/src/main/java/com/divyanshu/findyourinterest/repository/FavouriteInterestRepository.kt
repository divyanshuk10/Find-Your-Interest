package com.divyanshu.findyourinterest.repository

import androidx.annotation.WorkerThread
import com.divyanshu.findyourinterest.db.InterestDao
import com.divyanshu.findyourinterest.model.Interest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteInterestRepository @Inject constructor(
    private val interestDao: InterestDao
) {

    @WorkerThread
    suspend fun insertFavouriteInterest(interest: Interest) {
        interestDao.insertInterest(interest)
    }

    @WorkerThread
    suspend fun deleteInterest(interest: Interest) {
        interestDao.deleteInterest(interest)
    }

    val allInterest: Flow<List<Interest>> = interestDao.getAllFavouriteInterests()

}