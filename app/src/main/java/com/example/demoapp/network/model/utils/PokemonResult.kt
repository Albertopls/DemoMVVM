package com.example.demoapp.network.model.utils

data class PokemonResult<out T>(val status: Status, val data: T?, val message: String?){
    companion object {
        fun <T> success(data: T?): PokemonResult<T> =
            PokemonResult(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): PokemonResult<T> =
            PokemonResult(status = Status.ERROR, data = data, message = message)

    }
}
