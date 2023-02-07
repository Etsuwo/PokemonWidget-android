package com.example.pokemonwidget.api.response

import kotlinx.serialization.Serializable

@Serializable
data class SpeciesResponse(
    val names: List<Name>
)

@Serializable
data class Name(
    val name: String,
    val language: Language
)

@Serializable
data class Language(
    val name: String
)