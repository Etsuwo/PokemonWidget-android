package com.example.pokemonwidget.api

import com.example.pokemonwidget.api.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
}
