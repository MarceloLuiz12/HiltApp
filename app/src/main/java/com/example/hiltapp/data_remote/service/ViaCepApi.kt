package com.example.hiltapp.data_remote.service

import com.example.hiltapp.data_remote.responses.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): AddressResponse
}