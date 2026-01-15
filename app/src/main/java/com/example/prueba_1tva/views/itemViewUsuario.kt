package com.example.prueba_1tva.views

import androidx.collection.mutableIntListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba_1tva.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.listOf




class itemViewUsuario : ViewModel() {

    private val _lista: MutableStateFlow<List<Usuario>> = MutableStateFlow(emptyList())

    val lista = _lista

    var itemsList = mutableStateListOf(Usuario())
        private set

    var isLoading by mutableStateOf(false)
        private set


    fun fetchData(){
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                // Se excecuta cuando se termina de ejecutar
                isLoading = false
            }

        }
    }

    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            listOf<Usuario>(
                Usuario(
                    1,
                    "elemento 1",
                    "elemento 1",
                    "elemento 1",
                    "elemento 1",
                    "elemento 1",
                    "elemento 1"
                ),
                Usuario(
                    2,
                    "elemento 2",
                    "elemento 2",
                    "elemento 2",
                    "elemento 2",
                    "elemento 2",
                    "elemento 2"
                ),
                Usuario(
                    3,
                    "elemento 3",
                    "elemento 3",
                    "elemento 3",
                    "elemento 3",
                    "elemento 3",
                    "elemento 3"
                ),
                Usuario(
                    4,
                    "elemento 4",
                    "elemento 4",
                    "elemento 4",
                    "elemento 4",
                    "elemento 4",
                    "elemento 4"
                )
            )
            itemsList.addAll(result)
            _lista.value = result
        }
    }