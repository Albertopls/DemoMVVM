package com.example.demoapp.network.utils

import com.example.demoapp.R

// TODO: What is a data class?
// TODO: Why should this be declared as a data class?
// Read this docs: https://kotlinlang.org/docs/data-classes.html 😉
sealed class PokemonResult<out T> {

    class Success<out R>(val data: R?) : PokemonResult<R>()

    class Error(val message: String) : PokemonResult<Nothing>()

}




