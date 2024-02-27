package com.divyanshu.findyourinterest.repository

import com.divyanshu.findyourinterest.network.InterestAPI
import javax.inject.Inject

class InterestRepository @Inject constructor(private val apiService: InterestAPI) {

    suspend fun getRandomInterest() = apiService.getRandomInterest()
}