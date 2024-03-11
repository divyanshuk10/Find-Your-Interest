package com.divyanshu.network.retrofit

import com.divyanshu.model.BuildConfig
import com.divyanshu.model.Interest
import com.divyanshu.network.FYINetworkDataSource
import okhttp3.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

interface RetrofitFYINetworkApi {

    @GET(value = "activity/")
    suspend fun getRandomInterest(): Response<Interest>
}

private const val BASE_URL = BuildConfig.BASE_URL


@Singleton
internal class RetrofitFYINetwork @Inject constructor(
    httpClient: dagger.Lazy<Call.Factory>,
) : FYINetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        // We use callFactory lambda here with dagger.Lazy<Call.Factory>
        // to prevent initializing OkHttp on the main thread.
        .callFactory { httpClient.get().newCall(it) }
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(RetrofitFYINetworkApi::class.java)

    override suspend fun getRandomInterest(): Response<Interest> {
        return networkApi.getRandomInterest()
    }
}