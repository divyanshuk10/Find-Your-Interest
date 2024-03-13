package com.divyanshu.data.model

import com.divyanshu.database.model.InterestEntity
import com.divyanshu.network.model.NetworkInterest

fun NetworkInterest.asEntity() = InterestEntity(
    accessibility = accessibility,
    activity = activity,
    key = key,
    link = link,
    participants = participants,
    price = price,
    type = type,
)