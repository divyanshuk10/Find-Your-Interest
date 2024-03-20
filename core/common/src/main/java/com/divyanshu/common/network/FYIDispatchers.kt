package com.divyanshu.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val fyiDispatcher: FYIDispatchers)

enum class FYIDispatchers {
    Default,
    IO
}