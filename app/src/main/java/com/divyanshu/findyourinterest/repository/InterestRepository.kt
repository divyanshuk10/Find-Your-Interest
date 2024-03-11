package com.divyanshu.findyourinterest.repository

import com.divyanshu.findyourinterest.network.InterestNetworkAPI
import javax.inject.Inject

class InterestRepository @Inject constructor(private val apiService: InterestNetworkAPI) {

    suspend fun getRandomInterest() = apiService.getRandomInterest()
}