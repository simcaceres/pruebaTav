package com.example.prueba_1tva.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp


@Composable
fun TitleBar(name: String){
    Text(
        text = name, fontSize = 20.sp, color = Color.Red
    )
}

@Composable
fun ActionButton(){
    SmallFloatingActionButton(
        onClick = {/*TODO*/},
        contentColor = MaterialTheme.colorScheme.secondaryContainer,
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar")
    }
}

@Composable
fun MainIconButton(icon: ImageVector, onClick: () -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.Red)
    }
}