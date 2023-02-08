package com.example.pokemonwidget.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import com.example.pokemonwidget.R
import com.example.pokemonwidget.usecase.GetPokemonUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class PokemonWidgetProvider: AppWidgetProvider() {
    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach { appWidgetId ->
            CoroutineScope(Dispatchers.Default).launch {
                updateWidget(context, appWidgetManager, appWidgetId)
            }
        }
    }

    private suspend fun updateWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.widget_pokemon)
        val pokemon = GetPokemonUseCase().invoke()
        val bitmap = BitmapFactory.decodeStream(URL(pokemon.imageUrl).openConnection().getInputStream())
        views.setImageViewBitmap(R.id.widget_image, bitmap)
        views.setTextViewText(R.id.widget_pokemon_text, pokemon.name)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}