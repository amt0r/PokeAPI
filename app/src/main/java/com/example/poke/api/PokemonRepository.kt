package com.example.poke.api

import com.example.poke.model.PokeModel

private const val MAX_POKEMON_ID = 1025
private const val MIN_POKEMON_ID = 1

class PokemonRepository(private val pokeApiService: PokeApiService) {
    private val randomPokemons = mutableSetOf<PokeModel>()

    suspend fun getRandomPokemons(quantity: Int): MutableSet<PokeModel> {
        randomPokemons.clear()
        while (randomPokemons.size < quantity) {
            randomPokemons.add(pokeApiService.getPokemonById((MIN_POKEMON_ID..MAX_POKEMON_ID).random()))
        }

        return randomPokemons
    }
}
