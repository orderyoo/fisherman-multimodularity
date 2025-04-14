package com.example.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Scheme(
    val id: String,
    val name: String,
    val preview: String,
    val rating: Rating,
    @SerialName("user_comment_id")
    val userCommentId: String? = null,
    @SerialName("bounding_box")
    val boundingBox: BoundingBox? = null,
    val centerOfScheme: String? = null,
    val position: Int,
    val free: Boolean,
    val purchased: Boolean,
    @SerialName("billing_purchased")
    val billingPurchased: Boolean = false,
    @SerialName("product_id")
    val productId: String? = null,
    @SerialName("file_size")
    val fileSize: Int,
    @SerialName("file_version")
    val fileVersion: String,
    val prices: Prices,
    @SerialName("water_name")
    val waterName: String
)