package com.example.demoapp.presentation.ui.pokemonList

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.model.utils.ItemResult
import com.example.demoapp.network.model.utils.PokemonResult
import com.example.demoapp.network.model.utils.Status
import com.example.demoapp.repository.PokemonRepository
import kotlinx.coroutines.launch



class PokemonListViewModel
@ViewModelInject
    constructor(val pokemonRepository: PokemonRepository): ViewModel(){
    var result: MutableLiveData<PokemonResult<Pokemon>> = MutableLiveData()

    init {
        loadPokemons()

    }

    fun loadPokemons(){

        viewModelScope.launch {

            val res = try {
                pokemonRepository.searchPokemon()
            }catch (exception:Exception){
                ItemResult.Error(exception)
            }

            when (res) {
                is ItemResult.Success<Pokemon> ->
                    result.value = PokemonResult.success(data = res.data)
                is ItemResult.Error ->
                    result.value = res.exception.message?.let { PokemonResult.error(data = null, message = it) }
            }

        }


        }
    fun getPokemons(): MutableLiveData<PokemonResult<Pokemon>> {
        return  result
    }

}