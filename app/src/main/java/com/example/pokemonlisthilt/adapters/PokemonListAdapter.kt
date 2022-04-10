package com.example.pokemonlisthilt.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonlisthilt.R
import com.example.pokemonlisthilt.data.Pokemon
import com.example.pokemonlisthilt.databinding.ItemPokemonBinding
import com.example.pokemonlisthilt.viewmodel.PokemonViewModel

class PokemonListAdapter : ListAdapter<Pokemon, PokemonListAdapter.PokemonViewHolder>(PokemonDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class PokemonViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvPokemon: TextView = itemView.findViewById(R.id.tv_pokemon)
        fun bind(item: Pokemon) {
            tvPokemon.text = item.name
        }
    }

    class PokemonDiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
            oldItem == newItem

    }
}