package com.example.demoapp.network

import com.example.demoapp.network.model.Pokemon
import retrofit2.http.GET


interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemon() : Pokemon
}