package com.example.demoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.demoapp.R
import com.example.demoapp.network.utils.Country
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lambda =  { x: Int, y:Int -> x + y }

        var dato : (index: Int) -> Unit

        val funcion =  fun (x: Int, y:Int ):Int = x + y

        dato = { value ->

            Log.d("res",(value * 10).toString())
        }

        dato.invoke(lambda(2,4))
        funcion(2,3)
        Log.d("res",funcion.invoke(2,3).toString())


        var my_country = Country.Brasil

        when(my_country){
            Country.Mexico ->{

                Log.d("country", Country.Mexico.laguage)

            }
            Country.Brasil->{
                Log.d("country", Country.Brasil.laguage)


            }
            Country.Argentina ->{
                Log.d("country", Country.Argentina.laguage)

            }
            Country.Chile ->{
                Log.d("country", Country.Chile.laguage)


            }
            Country.Colombia->{
                Log.d("country", Country.Colombia.laguage)


            }
        }
    }

}