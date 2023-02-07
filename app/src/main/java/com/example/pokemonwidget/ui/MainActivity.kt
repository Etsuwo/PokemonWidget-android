package com.example.pokemonwidget.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.pokemonwidget.R

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        val button = findViewById<Button>(R.id.button)
        val pokemonText = findViewById<TextView>(R.id.pokemon_text)
        val imageView = findViewById<ImageView>(R.id.imageView)
        button.setOnClickListener {
            viewModel.onClickGetButton {
                Glide.with(imageView).load(Uri.parse(it.imageUrl)).into(imageView)
                pokemonText.text = it.name
            }
        }
    }
}