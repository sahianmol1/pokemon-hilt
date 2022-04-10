package com.example.pokemonlisthilt.repositories

import com.example.pokemonlisthilt.data.PokemonResponse
import retrofit2.Response

interface PokemonRepository {
    suspend fun getPokemonList(): Response<PokemonResponse>
}