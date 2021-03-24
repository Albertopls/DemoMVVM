package com.example.demoapp.network.model

import java.io.Serializable

data class Pokemon(var results: List<Result>)
data class Result(var name: String? = null, var url: String? = null): Serializable