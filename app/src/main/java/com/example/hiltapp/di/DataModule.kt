package com.example.hiltapp.di

import com.example.hiltapp.domain.repository.AddressRepository
import com.example.hiltapp.data.repository.AddressRepositoryImpl
import com.example.hiltapp.data_remote.service.ViaCepApi
import com.example.hiltapp.domain.usecase.GetAddressUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAddressRepository(apiService: ViaCepApi): AddressRepository {
        return AddressRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetAddressUseCase(repository: AddressRepository): GetAddressUseCase {
        return GetAddressUseCase(repository)
    }
}