package com.example.domain.usecase

import com.example.domain.model.Region
import com.example.domain.repository.SchemesRepository

class GetAllRegionsCase(private val schemesRepository: SchemesRepository) {
    suspend operator fun invoke(): Result<Region> = schemesRepository.getAllRegion()
}