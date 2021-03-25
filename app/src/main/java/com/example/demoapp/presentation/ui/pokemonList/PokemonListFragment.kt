package com.example.demoapp.presentation.ui.pokemonList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.R
import com.example.demoapp.network.model.Result
import com.example.demoapp.network.utils.Status
import com.example.demoapp.presentation.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

// TODO: Always follow Kotlin formatting conventions: 😉 https://kotlinlang.org/docs/coding-conventions.html#formatting
// TODO: To facilitate this, try to always use code indentation shortcut 😉 https://stackoverflow.com/a/16580200

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    private val viewModel: PokemonListViewModel by viewModels()
    private val onClickPokemonViewModel: OnclickPokemonViewModel by viewModels()
    private lateinit var adapter: PokemonAdapter
    lateinit var onPokemonClicked : (result: Result) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onPokemonClicked = { result ->
            onClickPokemonViewModel.onClickItem(result)
        }

        viewModel.getPokemons().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data?.results?.let { it1 -> setupUI(it1) }
                    }

                     Status.ERROR -> {
                         // Try to handle this error with a Snackbar or a Toast.
                    }
                     Status.LOADING -> {
                         // Do not implement unused states whenever possible.

                    }
                }
            }
        })

        onClickPokemonViewModel.getPokemonClicked().observe(viewLifecycleOwner, Observer {
            view.findNavController().navigate(R.id.action_pokemonListFragment_to_detailFragment, bundleOf("pokemon" to it))
        })

    }

    private fun setupUI(results:List<Result>){

        fragment_pokemon_list_rv_container.layoutManager = LinearLayoutManager(context)
        adapter = PokemonAdapter(result = results, onPokemonClicked = onPokemonClicked)
        fragment_pokemon_list_rv_container.adapter = adapter
    }

}