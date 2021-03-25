package com.example.demoapp.presentation.ui.pokemonDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.demoapp.R
import com.example.demoapp.network.model.Result
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

class DetailFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemPokemon = arguments?.getSerializable("pokemon") as Result
        frgament_detail_txt_name.text = itemPokemon.name


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_detail, container, false)
        // TODO: Do you really need the variable view? 😉
        return view
    }

}