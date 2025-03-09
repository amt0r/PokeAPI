package com.example.poke.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poke.R

@Composable
fun ReloadButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(120, 10, 10, 255),
                contentColor = Color.White
            ),
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.81f)
                .border(
                    width = 5.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                "Reload Pokemon",
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    Font(R.font.pixeled)
                )
            )
        }
    }
}
