package com.example.demoapp.network.utils

// TODO: What is a data class?
// TODO: Why should this be declared as a data class?
// Read this docs: https://kotlinlang.org/docs/data-classes.html 😉
data class PokemonResult<out T>(val status: Status, val data: T?, val message: String?){
    companion object {
        fun <T> success(data: T?): PokemonResult<T> =
            PokemonResult(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): PokemonResult<T> =
            PokemonResult(status = Status.ERROR, data = data, message = message)

    }
}
