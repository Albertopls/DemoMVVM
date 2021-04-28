package com.example.demoapp.presentation.ui.pokemonDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import coil.load
import com.example.demoapp.R
import com.example.demoapp.network.model.PokemonSpriteResponse
import com.example.demoapp.network.model.Result
import com.example.demoapp.network.utils.ItemResult
import com.example.demoapp.network.utils.PokemonResult
import com.example.demoapp.presentation.ui.pokemonList.PokemonListViewModel
import com.example.demoapp.utils.loadImageNetwork
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailPokemonViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonIndex = arguments?.getInt("pokemonIndex")

        val pokemonItem = arguments?.getSerializable("pokemonItem") as Result

        pokemonIndex?.let { viewModel.loadPokemonSprites(it) }


        viewModel._result.observe(viewLifecycleOwner, Observer {
            it?.let { resources ->

                when (resources) {
                    is ItemResult.Success<PokemonSpriteResponse> -> {

                        fragment_detail_pgb_progress.isVisible = false
                        resources.data?.sprites?.front_default?.let { it1 -> setUpUI(it1) }

                    }

                    is ItemResult.Error -> {

                        fragment_detail_pgb_progress.isVisible = false
                        Toast.makeText(context, resources.exception.message, Toast.LENGTH_LONG).show()
                    }

                    is ItemResult.Loading -> {

                        fragment_detail_pgb_progress.isVisible = true
                    }
                }

            }
        })


    }

    fun setUpUI(urlImage: String) {

        context?.let { frgament_detail_img_pokemon.loadImageNetwork(context = it,url = urlImage) }

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

}