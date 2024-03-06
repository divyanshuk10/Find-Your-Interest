package com.divyanshu.findyourinterest.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "interest_table")
data class Interest(
    val accessibility: Double,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String
) : Parcelable{
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}