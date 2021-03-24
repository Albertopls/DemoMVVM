package com.example.demoapp.network.model

import retrofit2.http.GET
import kotlin.Result

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemon() : Pokemon
}