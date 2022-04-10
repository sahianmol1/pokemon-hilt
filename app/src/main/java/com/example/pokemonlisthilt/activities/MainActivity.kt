package com.example.pokemonlisthilt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonlisthilt.adapters.PokemonListAdapter
import com.example.pokemonlisthilt.databinding.ActivityMainBinding
import com.example.pokemonlisthilt.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: PokemonViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonAdapter: PokemonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pokemonAdapter = PokemonListAdapter()

        binding.rvPokemon.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pokemonAdapter
        }

        viewModel.getPokemonList()
        viewModel.pokemonList.observe(this) { pokemonList ->
            Toast.makeText(this, "the number of Pokemon fetched is: ${pokemonList.size}", Toast.LENGTH_LONG).show()
            pokemonAdapter.submitList(pokemonList)
        }
    }
}