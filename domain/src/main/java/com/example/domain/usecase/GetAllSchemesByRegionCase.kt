package com.example.domain.usecase

import com.example.domain.model.Scheme
import com.example.domain.repository.SchemesRepository

class GetAllSchemesByRegionCase(private val schemesRepository: SchemesRepository) {
    suspend operator fun invoke(token: String?): Result<List<Scheme>> = schemesRepository.getAllSchemeByRegion(token)
}