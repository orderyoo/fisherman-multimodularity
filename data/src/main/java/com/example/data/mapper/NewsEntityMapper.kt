package com.example.data.mapper

import com.example.data.db.entities.NewsEntity
import com.example.domain.model.News


fun NewsEntity.toNews(): News {
    return News(id, publicationDate, title, urlImage)
}

fun News.toNewsEntity(): NewsEntity {
    return NewsEntity(
        id,
        publicationDate,
        title,
        urlImage
    )
}
