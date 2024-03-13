package com.divyanshu.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.divyanshu.model.Interest

@Entity(tableName = "interests")
data class InterestEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val accessibility: Double,
    @ColumnInfo(defaultValue = "")
    val activity: String,
    @ColumnInfo(defaultValue = "")
    val key: String,
    @ColumnInfo(defaultValue = "")
    val link: String,
    val participants: Int,
    val price: Double,
    @ColumnInfo(defaultValue = "")
    val type: String
)

fun InterestEntity.asExternalModel() = Interest(
    accessibility = accessibility,
    activity = activity,
    key = key,
    link = link,
    participants = participants,
    price = price,
    type = type
)
