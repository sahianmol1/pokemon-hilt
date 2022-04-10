package com.example.pokemonlisthilt.repositories

import com.example.pokemonlisthilt.data.PokemonApi
import com.example.pokemonlisthilt.data.PokemonResponse
import retrofit2.Response
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonApi: PokemonApi): PokemonRepository {
    override suspend fun getPokemonList(): Response<PokemonResponse> = pokemonApi.getPokemonList()
}