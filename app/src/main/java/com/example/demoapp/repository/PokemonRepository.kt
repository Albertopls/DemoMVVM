package com.example.demoapp.repository

import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.model.utils.ItemResult

interface PokemonRepository  {
     suspend fun searchPokemon(): ItemResult<Pokemon>
}