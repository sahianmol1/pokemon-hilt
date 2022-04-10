package com.example.pokemonlisthilt.data

import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon/")
    suspend fun getPokemonList() : Response<PokemonResponse>

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}