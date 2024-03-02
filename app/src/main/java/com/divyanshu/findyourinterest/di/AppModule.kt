package com.divyanshu.findyourinterest.di

import com.divyanshu.findyourinterest.network.InterestAPI
import com.divyanshu.findyourinterest.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl() = Constant.BASE_URL

    @Provides
    fun providesNetworkInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        return loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesOkhttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).build()

    @Provides
    fun providesRetrofitInstance(baseUrl: String, okHttpClient: OkHttpClient): InterestAPI =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(InterestAPI::class.java)

}