package com.example.poke.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.poke.model.PokeModel
import com.example.poke.R

@Composable
fun PokeCard(pokemon: PokeModel) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(25.dp)
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    Brush.randomGradient(),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(pokemon.sprite.image),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color(0, 0, 0, 90))
                    .border(
                        width = 5.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(50.dp)
                    )
            )
            Text(
                text = pokemon.name.replaceFirstChar { it.titlecase() },
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                fontFamily = FontFamily(
                    Font(R.font.pixeled)
                ),
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Move 1:   ${pokemon.moves.first().move.name.replaceFirstChar { it.titlecase() }}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                fontFamily = FontFamily(
                    Font(R.font.pixeled)
                ),
            )
            Text(
                text = "Move 2:   ${pokemon.moves.last().move.name.replaceFirstChar { it.titlecase() }}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                fontFamily = FontFamily(
                    Font(R.font.pixeled)
                ),
            )
        }
    }
}