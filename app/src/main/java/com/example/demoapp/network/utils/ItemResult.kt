package com.example.demoapp.network.utils

// TODO: What is a sealed class?
// TODO: Why should this be declared as a sealed class?
// Read this docs: https://kotlinlang.org/docs/sealed-classes.html 😉
sealed class ItemResult<out R> {
    data class Success<out T>(val data: T) : ItemResult<T>()
    data class Error(val exception: Exception) : ItemResult<Nothing>()
}