package com.example.demoapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.network.model.Result
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(val result:List<Result>, val onPokemonClicked : (index: Int) -> Unit):
        RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(result:Result){
            itemView.apply {
                item_pokemon_txt_name.text= result.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {

        val holder = PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false))

        holder.itemView.item_pokemon_cv_container.setOnClickListener {
            onPokemonClicked.invoke(holder.adapterPosition+1)
        }
        return holder

    }

    override fun getItemCount(): Int = result.size

    // TODO: Keep attention to android warnings -> In the following line you should use the get method with Indexing 😉
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bind(result = result.get(position))

}