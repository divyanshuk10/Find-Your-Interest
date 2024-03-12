package com.divyanshu.network

import com.divyanshu.model.Interest
import com.divyanshu.network.model.NetworkInterest
import retrofit2.Response

interface FYINetworkDataSource {
    suspend fun getRandomInterest(): NetworkInterest
}