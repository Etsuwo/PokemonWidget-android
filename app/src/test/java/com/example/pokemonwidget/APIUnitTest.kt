package com.example.pokemonwidget

import com.example.pokemonwidget.api.PokeAPIClient
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class APIUnitTest {
    private val pikachuId = 25

    @Test
    fun getPokemon_isSuccess() {
        val expectedUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
        val result = runBlocking { PokeAPIClient.api.getPokemon(pikachuId) }
        assertEquals(expectedUrl, result.sprites.other.officialArtwork.frontDefault)
    }
}