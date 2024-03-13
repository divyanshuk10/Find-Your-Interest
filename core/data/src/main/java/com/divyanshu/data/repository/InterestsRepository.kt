package com.divyanshu.data.repository

import com.divyanshu.data.Syncable
import com.divyanshu.model.Interest
import kotlinx.coroutines.flow.Flow

interface InterestsRepository : Syncable {
    /**
     * Gets the available interests as a stream
     */
    fun getInterests(): Flow<List<Interest>>

}