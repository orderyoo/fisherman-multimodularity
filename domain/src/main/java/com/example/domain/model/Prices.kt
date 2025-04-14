package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prices(
    @SerialName("google")
    val google: Int = 0,
    @SerialName("apple")
    val apple: Int = 0,
)