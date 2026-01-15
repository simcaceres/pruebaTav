package com.example.prueba_1tva.data

import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.serialization.Contextual
import java.util.prefs.Preferences

class StoreDarkModel(private val context: Context) {

    companion object{
        private val Context.dataStore: DataStore<Preferences> by
    }



}

