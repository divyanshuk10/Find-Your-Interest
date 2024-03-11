package com.divyanshu.network.retrofit

import com.divyanshu.model.Interest
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitFYINetwork {

    @GET("activity/")
    suspend fun getRandomInterest(): Response<Interest>
}