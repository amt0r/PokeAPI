package com.example.poke.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poke.model.PokeModel
import com.example.poke.api.PokemonRepository
import com.example.poke.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel() : ViewModel() {
    private val _pokemons = MutableStateFlow<List<PokeModel>>(emptyList())
    val pokemons: StateFlow<List<PokeModel>> get() = _pokemons

    private var _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    private val pokeRepository = PokemonRepository(RetrofitInstance.pokeApi)

    fun reloadPokemons(quantity: Int) {
        viewModelScope.launch {
            try {
                val newPokemons = pokeRepository.getRandomPokemons(quantity)
                _pokemons.value = newPokemons.toList()
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load pokemons"
                Log.e("PokemonViewModel", "Failed to load pokemons", e)
            }
        }
    }

    fun sortByNameAlphabetical() {
        _pokemons.value = _pokemons.value.sortedBy { it.name }
    }

    fun sortByNameReverseAlphabetical() {
        _pokemons.value = _pokemons.value.sortedByDescending { it.name }
    }

    fun sortByMovesAlphabetical() {
        _pokemons.value = _pokemons.value.sortedBy { it.moves.joinToString() }
    }

    fun sortByMovesReverseAlphabetical() {
        _pokemons.value = _pokemons.value.sortedByDescending { it.moves.joinToString() }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}
