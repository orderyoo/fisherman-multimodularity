package com.example.domain.repository

import com.example.domain.model.Region
import com.example.domain.model.Scheme

interface SchemesRepository {
    suspend fun getSchemeByName(name: String): Result<List<Scheme>>
    suspend fun getAllSchemeByRegion(water_id: String, token: String?): Result<List<Scheme>>
    suspend fun getAllRegion(): Result<List<Region>>
}