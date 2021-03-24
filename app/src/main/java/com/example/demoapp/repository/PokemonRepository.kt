package com.example.demoapp.repository

import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.utils.ItemResult

interface PokemonRepository  {
     suspend fun searchPokemon(): ItemResult<Pokemon>
}