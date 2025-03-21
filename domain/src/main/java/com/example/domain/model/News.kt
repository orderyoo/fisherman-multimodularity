package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    @SerialName("id")
    val id: String,
    @SerialName("publication_date")
    val publicationDate: String,
    @SerialName("title")
    val title: String,
    @SerialName("url_image")
    val urlImage: String?
)