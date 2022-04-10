package com.example.pokemonlisthilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonlisthilt.data.Pokemon
import com.example.pokemonlisthilt.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> get() = _pokemonList

    fun getPokemonList() =  viewModelScope.launch {
        val response = repository.getPokemonList()
        if (response.isSuccessful && response.body() != null) {
            _pokemonList.value = response.body()!!.pokemonList
        }
    }
}