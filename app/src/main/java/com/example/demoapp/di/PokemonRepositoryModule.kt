package com.example.demoapp.di

import com.example.demoapp.network.model.PokemonService
import com.example.demoapp.repository.PokemonRepository
import com.example.demoapp.repository.PokemonRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PokemonRepositoryModule {

    @Singleton
    @Provides
    fun providesPokemonRepository(pokemonService: PokemonService): PokemonRepository{
        return PokemonRepository_Impl(pokemonService)
    }
}