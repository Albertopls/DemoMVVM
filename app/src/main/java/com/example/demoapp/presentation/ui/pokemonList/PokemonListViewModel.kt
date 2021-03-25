package com.example.demoapp.presentation.ui.pokemonList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.utils.ItemResult
import com.example.demoapp.network.utils.PokemonResult
import com.example.demoapp.repository.PokemonRepository
import kotlinx.coroutines.launch

// TODO: Always follow Kotlin formatting conventions: 😉 https://kotlinlang.org/docs/coding-conventions.html#formatting
// TODO: To facilitate this, try to always use code indentation shortcut 😉 https://stackoverflow.com/a/16580200

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