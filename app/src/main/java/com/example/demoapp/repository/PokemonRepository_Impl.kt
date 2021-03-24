package com.example.demoapp.repository

import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.PokemonService
import com.example.demoapp.network.utils.ItemResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository_Impl(val pokemonService: PokemonService): PokemonRepository {

    override suspend fun searchPokemon(): ItemResult<Pokemon> {

        return withContext(Dispatchers.IO){

            return@withContext ItemResult.Success(data = pokemonService.getPokemon())

        }

    }

}