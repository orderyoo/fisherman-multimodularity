package com.example.domain.repository

import com.example.domain.model.Region
import com.example.domain.model.Scheme

interface SchemesRepository {
    suspend fun getSchemeByName(name: String): Result<Scheme>
    suspend fun getAllSchemeByRegion(token: String?): Result<Scheme>
    suspend fun getAllRegion(): Result<Region>
}