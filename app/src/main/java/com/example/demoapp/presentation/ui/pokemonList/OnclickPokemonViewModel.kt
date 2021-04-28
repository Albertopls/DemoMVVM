package com.example.demoapp.presentation.ui.pokemonList

import androidx.lifecycle.ViewModel
import com.example.demoapp.network.model.Result
import com.example.demoapp.network.utils.SingleLiveData

// TODO: Always follow Kotlin formatting conventions: 😉 https://kotlinlang.org/docs/coding-conventions.html#formatting
// TODO: To facilitate this, try to always use code indentation shortcut 😉 https://stackoverflow.com/a/16580200

class OnclickPokemonViewModel : ViewModel(){

    var item: SingleLiveData<Int> = SingleLiveData()

    fun onClickItem(index: Int){
        item.value = index
    }

    fun getPokemonClicked(): SingleLiveData<Int>{

        return item
    }
}