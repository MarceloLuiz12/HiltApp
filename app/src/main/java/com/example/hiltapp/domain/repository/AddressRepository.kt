package com.example.hiltapp.domain.repository

import com.example.hiltapp.data_remote.responses.AddressResponse

interface AddressRepository {
    suspend fun getAddress(cep: String): AddressResponse
}