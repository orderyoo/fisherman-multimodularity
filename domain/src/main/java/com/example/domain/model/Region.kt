package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Region(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("schemes")
    val schemes: String
)