package com.example.poke.view

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.poke.viewmodel.PokemonViewModel

private const val QUANTITY_OF_POKEMONS = 10

@Composable
fun MainScreen(pokemonViewModel: PokemonViewModel = PokemonViewModel()) {
    val pokemons by pokemonViewModel.pokemons.collectAsState()
    val errorMessage by pokemonViewModel.errorMessage.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        pokemonViewModel.reloadPokemons(QUANTITY_OF_POKEMONS)
    }

    if (errorMessage != null) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        pokemonViewModel.clearError()
    }

    val sortButtons: List<Pair<String, () -> Unit>> = listOf(
        "Name Alphabet" to { pokemonViewModel.sortByNameAlphabetical() },
        "Name Alphabet Reverse" to { pokemonViewModel.sortByNameReverseAlphabetical() },
        "Moves Alphabet" to { pokemonViewModel.sortByMovesAlphabetical() },
        "Moves Alphabet Reverse" to { pokemonViewModel.sortByMovesReverseAlphabetical() }
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(24, 24, 24, 255)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(sortButtons) { (text, onClick) ->
                        Spacer(modifier = Modifier.width(6.dp))
                        SortButton(text = text, onClick = onClick)
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }

            items(pokemons.toList()) { pokemon ->
                PokeCard(pokemon)
            }

            item {
                Spacer(modifier = Modifier.height(75.dp))
            }
        }

        ReloadButton {
            pokemonViewModel.reloadPokemons(QUANTITY_OF_POKEMONS)
        }
    }
}


