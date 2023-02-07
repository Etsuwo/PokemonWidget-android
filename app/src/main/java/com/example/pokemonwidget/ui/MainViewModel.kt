package com.example.pokemonwidget.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonwidget.usecase.GetPokemonUseCase
import com.example.pokemonwidget.usecase.Pokemon
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    fun onClickGetButton(callback: (Pokemon) -> Unit) {
        viewModelScope.launch {
            try {
                val pokemon = GetPokemonUseCase().invoke()
                callback(pokemon)
            } catch (e: Exception) {
                Log.e("error", "catch error")
            }
        }
    }

}