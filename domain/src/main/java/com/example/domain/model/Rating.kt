package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    @SerialName("average")
    val average: Float = 0.0f,
    @SerialName("count")
    val count: Int = 0,
)
