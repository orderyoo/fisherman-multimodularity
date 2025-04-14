package com.example.domain.repository

import com.example.domain.model.Region

interface RegionRepository {
    suspend fun getAllRegion(): Result<Region>
}