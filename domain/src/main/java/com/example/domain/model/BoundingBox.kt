package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoundingBox(
    @SerialName("north")
    val north: Double,
    @SerialName("south")
    val south: Double,
    @SerialName("west")
    val west: Double,
    @SerialName("east")
    val east: Double
)

//fun BoundingBox.toMapLatLng() = MapLatLng(
//    latitude = (south + north) / 2,
//    longitude = (west + east) / 2,
//)