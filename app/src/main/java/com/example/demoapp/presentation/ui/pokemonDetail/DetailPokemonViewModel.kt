package com.example.demoapp.presentation.ui.pokemonDetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.network.model.Pokemon
import com.example.demoapp.network.model.PokemonSpriteResponse
import com.example.demoapp.network.utils.ItemResult
import com.example.demoapp.network.utils.PokemonResult
import com.example.demoapp.repository.PokemonRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailPokemonViewModel
@ViewModelInject
constructor(val pokemonRepository: PokemonRepository) : ViewModel() {

    private val result: MutableLiveData<ItemResult<PokemonSpriteResponse>> = MutableLiveData()
    val _result: LiveData<ItemResult<PokemonSpriteResponse>> = result

    fun loadPokemonSprites(pokemonIndex: Int) {
        result.value = ItemResult.Loading(null)
        viewModelScope.launch {
            delay(3000)
            result.value = pokemonRepository.getPokemonSprites(pokemonIndex = pokemonIndex)
        }

    }
}