package com.example.demoapp.repository

import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.PokemonService
import com.example.demoapp.network.model.PokemonSpriteResponse
import com.example.demoapp.network.utils.ItemResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// TODO: Class names must not contain underscores.
// TODO: Check the Kotlin coding conventions: https://kotlinlang.org/docs/coding-conventions.html#names-for-backing-properties
class PokemonRepository_Impl(val pokemonService: PokemonService) : PokemonRepository {

    override suspend fun searchPokemon(): ItemResult<Pokemon> {
        return withContext(Dispatchers.IO) {
            return@withContext ItemResult.Success(data = pokemonService.getPokemon())
        }
    }

    override suspend fun getPokemonSprites(pokemonIndex: Int): ItemResult<PokemonSpriteResponse> {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext ItemResult.Success(
                    data = pokemonService.getPokemonSprites(
                        pokemonIndex
                    )
                )
            } catch (exception: Exception) {
                return@withContext ItemResult.Error(exception = exception)
            }

        }
    }

}