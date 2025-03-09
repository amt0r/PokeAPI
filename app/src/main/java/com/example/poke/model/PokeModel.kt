package com.example.poke.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokeModel(
    @Json(name = "name") val name: String,
    @Json(name = "sprites") val sprite: SpriteModel,
    @Json(name = "moves") val moves: List<MovesModel>
)

@JsonClass(generateAdapter = true)
data class MovesModel(
    @Json(name = "move") val move: MoveDetailModel
)

@JsonClass(generateAdapter = true)
data class MoveDetailModel(
    @Json(name = "name") val name: String
)

@JsonClass(generateAdapter = true)
data class SpriteModel(
    @Json(name = "front_default") val image: String
)
