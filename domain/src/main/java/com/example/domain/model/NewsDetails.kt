package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDetails(
    @SerialName("publication_date")
    val publicationDate: String,
    @SerialName("title")
    val title: String,
    @SerialName("text")
    val text: String,
    @SerialName("url_image")
    val urlImage: String?,
    @SerialName("water_id")
    val waterId: String?,
    @SerialName("water_name")
    val waterName: String?,
    @SerialName("schema_id")
    val schemaId: String?
)