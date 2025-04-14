package com.example.data.repository

import com.example.data.network.RemoteDataSource
import com.example.data.network.safeApiCall
import com.example.domain.model.Region
import com.example.domain.model.Scheme
import com.example.domain.repository.SchemesRepository

class SchemesRepositoryImpl(private val remoteDataSource: RemoteDataSource): SchemesRepository {
    override suspend fun getSchemeByName(name: String): Result<Scheme> {
        return safeApiCall { remoteDataSource.getSchemeByName(name) }
    }

    override suspend fun getAllSchemeByRegion(token: String?): Result<Scheme> {
        return safeApiCall { remoteDataSource.getAllSchemesByRegion(token) }
    }

    override suspend fun getAllRegion(): Result<Region> {
        return safeApiCall { remoteDataSource.getAllRegions() }
    }
}