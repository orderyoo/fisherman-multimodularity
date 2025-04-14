package com.example.domain.usecase

import com.example.domain.model.Scheme
import com.example.domain.repository.SchemesRepository

class GetAllSchemesByNameCase(private val schemesRepository: SchemesRepository) {
    suspend operator fun invoke(name: String): Result<Scheme> = schemesRepository.getSchemeByName(name)
}