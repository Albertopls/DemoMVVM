package com.example.demoapp.network

import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.model.PokemonSpriteResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemon(): Pokemon

    @GET("pokemon/{index}")
    suspend fun getPokemonSprites(@Path("index") pokemonIndex: Int): PokemonSpriteResponse
}