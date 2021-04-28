package com.example.demoapp.network.utils

import android.util.Log

interface Capital {
    fun capital()
}
enum class Country(var laguage: String) :Capital {
    Mexico("spanish") {
        override fun capital() {

            Log.d("capital", "Mexico city")
        }
    },
    Chile("spanish") {
        override fun capital() {
            Log.d("capital", "Santiago chile")

        }
    },
    Brasil("portugues") {
        override fun capital() {
            Log.d("capital", "Brasilia")

        }
    },
    Colombia("spanish") {
        override fun capital() {
            Log.d("capital", "Bogota")

        }
    },
    Argentina("spanish") {
        override fun capital() {
            Log.d("capital", "Buenos Aires")

        }
    }
}