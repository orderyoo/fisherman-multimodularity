package com.example.domain.usecase

import com.example.domain.model.Region
import com.example.domain.repository.RegionRepository

class GetAllRegionsCase(private val regionRepository: RegionRepository) {
    suspend operator fun invoke(): Result<Region> = regionRepository.getAllRegion()
}