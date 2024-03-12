package com.divyanshu.model

/**
 * External data layer representation of an Interest
 */
data class Interest(
    var id: Int? = null,
    val accessibility: Double,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String
)