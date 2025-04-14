package com.example.data.repository

import com.example.data.network.RemoteDataSource
import com.example.data.network.safeApiCall
import com.example.domain.model.Region
import com.example.domain.repository.RegionRepository

class RegionRepositoryImpl(private val remoteDataSource: RemoteDataSource): RegionRepository {
    override suspend fun getAllRegion(): Result<Region> {
        return safeApiCall { remoteDataSource.getAllRegions() }
    }
}