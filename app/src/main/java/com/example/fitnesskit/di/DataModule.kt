package com.example.fitnesskit.di

import com.example.fitnesskit.data.ApiFactory
import com.example.fitnesskit.data.ApiService
import com.example.fitnesskit.data.FitnessRepositoryImpl
import com.example.fitnesskit.domain.repository.FitnessRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindPhoneRepository(impl: FitnessRepositoryImpl): FitnessRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}