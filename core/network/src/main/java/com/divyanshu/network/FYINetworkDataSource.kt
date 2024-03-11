package com.divyanshu.network

import com.divyanshu.model.Interest
import retrofit2.Response
import retrofit2.http.GET

interface FYINetworkDataSource {

    @GET("activity/")
    suspend fun getRandomInterest(): Response<Interest>
}