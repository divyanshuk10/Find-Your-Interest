package com.divyanshu.network

import com.divyanshu.model.Interest
import retrofit2.Response

interface FYINetworkDataSource {
    suspend fun getRandomInterest(): Response<Interest>
}