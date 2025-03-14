package com.example.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo
    val publicationDate: String, // в формате "Y.m.d"
    @ColumnInfo
    val title: String,
    @ColumnInfo val
    urlImage: String?
)