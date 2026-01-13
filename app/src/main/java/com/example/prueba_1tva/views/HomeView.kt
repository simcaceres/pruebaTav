package com.example.prueba_1tva.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.prueba_1tva.components.ActionButton
import com.example.prueba_1tva.components.MainButton
import com.example.prueba_1tva.components.Space
import com.example.prueba_1tva.components.TitleBar
import com.example.prueba_1tva.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParamenter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, modifier: Modifier = Modifier){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ){
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController){
    val id = 456
    var opcional by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name = " Home View")
        Space(width = 0, height = 10)
        TextField(
            value = opcional,
            onValueChange = { opcional = it},
            label = { Text(text = "Opcional")}
        )
        Space(width = 0, height = 10)
        MainButton(
            name = "Detail View",
            backColor = MaterialTheme.colorScheme.primary,
            color = MaterialTheme.colorScheme.onPrimary
        ) {
            navController.navigate("Detail/${id}/?${opcional}")
            println("Soy un boton generico")
        }

    }
}

