package com.baladroid.baseapp.domain.usecase

import com.baladroid.baseapp.domain.repository.BaseRepository

data class CountriesUseCase (
    val getAllCountries: GetAllCountries
)

class GetAllCountries(private val baseRepository: BaseRepository) {
    suspend operator fun invoke() = baseRepository.getAllCountries()
}