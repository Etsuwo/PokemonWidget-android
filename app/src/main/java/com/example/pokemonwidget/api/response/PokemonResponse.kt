package com.example.pokemonwidget.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val sprites: Sprites
)

@Serializable
data class Sprites(
    val other: Other
)

@Serializable
data class Other(
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtwork
)

@Serializable
data class OfficialArtwork(
    @SerialName("front_default")
    val frontDefault: String
)
