package com.example.demoapp.presentation.ui.pokemonList

import androidx.lifecycle.ViewModel
import com.example.demoapp.network.model.Result
import com.example.demoapp.network.utils.SingleLiveData

class OnclickPokemonViewModel : ViewModel(){

    var pokemon: SingleLiveData<Result> = SingleLiveData()

    fun onClickItem(item: Result){
        pokemon.value = item
    }

    fun getPokemonClicked(): SingleLiveData<Result>{

        return pokemon
    }
}