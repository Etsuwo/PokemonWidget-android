package com.example.pokemonwidget.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object PokeAPIClient {
    private val contentType = "application/json"
    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    private val format = Json { ignoreUnknownKeys = true }

    @OptIn(ExperimentalSerializationApi::class)
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(format.asConverterFactory(MediaType.get(contentType)))
        .build()

    val api = builder.create(PokeAPI::class.java)
}