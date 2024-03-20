package com.divyanshu.data.di

import com.divyanshu.data.repository.InterestsRepository
import com.divyanshu.data.repository.OfflineFirstInterestsRepository
import com.divyanshu.data.utils.ConnectivityManagerNetworkMonitor
import com.divyanshu.data.utils.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsInterestRepository(interestsRepository: OfflineFirstInterestsRepository): InterestsRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(networkMonitor: ConnectivityManagerNetworkMonitor): NetworkMonitor
}