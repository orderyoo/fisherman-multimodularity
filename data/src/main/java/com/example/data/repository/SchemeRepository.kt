package com.example.data.repository

import com.example.data.network.RemoteDataSource
import com.example.data.network.safeApiCall
import com.example.domain.model.Region
import com.example.domain.model.Scheme
import com.example.domain.repository.SchemesRepository

class SchemesRepositoryImpl(private val remoteDataSource: RemoteDataSource): SchemesRepository {
    override suspend fun getSchemeByName(name: String): Result<List<Scheme>> {
        return safeApiCall { remoteDataSource.getSchemeByName(name) }
    }

    override suspend fun getAllSchemeByRegion(water_id: String, token: String?): Result<List<Scheme>> {
        return safeApiCall { remoteDataSource.getAllSchemesByRegion(water_id, token) }
    }

    override suspend fun getAllRegion(): Result<List<Region>> {
        return safeApiCall { remoteDataSource.getAllRegions() }
    }
}