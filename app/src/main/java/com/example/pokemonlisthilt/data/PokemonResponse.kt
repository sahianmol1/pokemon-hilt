package com.example.pokemonlisthilt.data

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")
    val pokemonList: List<Pokemon>
)