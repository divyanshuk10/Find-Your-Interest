package com.divyanshu.model

sealed class Result<out T> {

    data object Loading : Result<Nothing>()

    data class Success<out T>(val data: T?) : Result<T>()

    class Error(val message: String, val code: Int) : Result<Nothing>()

    fun toData(): T? = (this as? Success)?.data
}

