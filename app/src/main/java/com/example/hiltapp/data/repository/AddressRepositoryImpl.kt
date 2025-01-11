package com.example.hiltapp.data.repository

import com.example.hiltapp.data_remote.responses.AddressResponse
import com.example.hiltapp.domain.repository.AddressRepository
import com.example.hiltapp.data_remote.service.ViaCepApi
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    private val api: ViaCepApi
) : AddressRepository {
    override suspend fun getAddress(cep: String): AddressResponse {
        return api.getAddress(cep)
    }
}