package com.example.prueba_1tva.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.prueba_1tva.components.MainIconButton
import com.example.prueba_1tva.components.TitleBar
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.prueba_1tva.components.Space
import com.example.prueba_1tva.components.TitleView
import androidx.compose.material.icons.filled.ArrowBack
import com.example.prueba_1tva.components.MainButton


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id : Int, opcional: String?){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentDetailView(navController, id, opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id : Int, opcional: String?){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name = "Detail View")
        Space(width = 0, height = 10)
        TitleView(name = id.toString())
        Space(width = 0, height = 10)
        if (opcional == ""){
            Space(width = 0, height = 0)
        }else{
            TitleView(name = opcional.orEmpty())
            Space(width = 0, height = 10)
        }
        MainButton(name = "Return Home View", backColor = MaterialTheme.colorScheme.primary, color = MaterialTheme.colorScheme.onPrimary) {
            navController.popBackStack()
            println("Soy un boton generico")
        }
    }
}