package com.example.poke.view

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poke.R

@Composable
fun SortButton(text: String, onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(120, 10, 10, 255),
            contentColor = Color.White
        ),
        onClick = onClick,
        modifier = Modifier
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            text,
            fontSize = 14.sp,
            fontFamily = FontFamily(
                Font(R.font.pixeled)
            )
        )
    }
}
