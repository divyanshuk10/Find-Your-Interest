package com.divyanshu.data.repository

import com.divyanshu.data.Synchronizer
import com.divyanshu.database.dao.InterestDao
import com.divyanshu.database.model.InterestEntity
import com.divyanshu.database.model.asExternalModel
import com.divyanshu.model.Interest
import com.divyanshu.network.FYINetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class OfflineFirstInterestsRepository constructor(
    private val interestDao: InterestDao,
    private val networkDataSource: FYINetworkDataSource
) : InterestsRepository {

    override fun getInterests(): Flow<List<Interest>> =
        interestDao.getAllFavouriteInterests()
            .map { it.map(InterestEntity::asExternalModel) }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {

       return true

    }

}