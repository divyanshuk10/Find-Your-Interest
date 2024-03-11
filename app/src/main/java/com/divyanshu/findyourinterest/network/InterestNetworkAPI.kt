package com.divyanshu.findyourinterest.network

import com.divyanshu.findyourinterest.model.Interest
import retrofit2.Response
import retrofit2.http.GET

interface InterestNetworkAPI {

    @GET("activity/")
    suspend fun getRandomInterest(): Response<Interest>
}