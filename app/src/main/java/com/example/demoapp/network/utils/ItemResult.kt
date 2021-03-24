package com.example.demoapp.network.utils

sealed class ItemResult<out R> {
    data class Success<out T>(val data: T) : ItemResult<T>()
    data class Error(val exception: Exception) : ItemResult<Nothing>()
}