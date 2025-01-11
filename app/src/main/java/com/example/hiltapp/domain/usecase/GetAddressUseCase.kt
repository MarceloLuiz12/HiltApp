package com.example.hiltapp.domain.usecase

import com.example.hiltapp.domain.model.AddressModel
import com.example.hiltapp.domain.repository.AddressRepository
import javax.inject.Inject

class GetAddressUseCase @Inject constructor(
    private val repository: AddressRepository
) {
    suspend operator fun invoke(cep: String): AddressModel {
        val response = repository.getAddress(cep)
        return AddressModel(
            postalCode = response.postalCode,
            street = response.street,
            neighborhood = response.neighborhood,
            city = response.city,
            state = response.state
        )
    }
}