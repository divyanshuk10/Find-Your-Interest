package com.divyanshu.findyourinterest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Interest(
    val accessibility: Double,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String
) : Parcelable