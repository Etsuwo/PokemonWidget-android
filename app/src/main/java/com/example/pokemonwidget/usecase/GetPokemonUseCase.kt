package com.example.pokemonwidget.usecase

import com.example.pokemonwidget.api.PokeAPIClient
import com.example.pokemonwidget.api.PokeAPIConstants
import java.security.SecureRandom

class GetPokemonUseCase {
    suspend operator fun invoke(): Pokemon {
        val id = SecureRandom().nextInt(PokeAPIConstants.MAX_ID + 1)
        val url = PokeAPIClient.api.getPokemon(id).sprites.other.officialArtwork.frontDefault
        val name = PokeAPIClient.api.getSpecies(id).names.first {
            it.language.name == "ja-Hrkt"
        }.name
        return Pokemon(name, url)
    }
}

data class Pokemon(
    val name: String,
    val imageUrl: String
)