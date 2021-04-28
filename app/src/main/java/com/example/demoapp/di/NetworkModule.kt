package com.example.demoapp.di

import android.app.Application
import android.content.Context
import com.example.demoapp.network.PokemonService
import com.example.demoapp.network.utils.OkHttpClient
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        return OkHttpClient(appContext)
    }


    @Singleton
    @Provides
    fun providePokemonService(okHttpClient: OkHttpClient): PokemonService {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient.okHttpClient)
            .build()
            .create(PokemonService::class.java)
    }

}