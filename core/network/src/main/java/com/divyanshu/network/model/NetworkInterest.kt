package com.divyanshu.network.model

import com.divyanshu.model.Interest
import kotlinx.serialization.Serializable

/**
 * Network representation of [Interest]
 */
@Serializable
data class NetworkInterest(
    val accessibility: Double = 0.0,
    val activity: String = "",
    val key: String = "",
    val link: String = "",
    val participants: Int = 0,
    val price: Double = 0.0,
    val type: String = ""
)

