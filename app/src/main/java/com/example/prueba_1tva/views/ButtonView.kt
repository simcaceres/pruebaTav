package com.example.prueba_1tva.views

import android.widget.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.xr.scenecore.Space

@Composable
fun SmallButton(smallButton: MutableState<Boolean>){
    Button(onClick = {
        smallButton.value = !smallButton.value
    })
    {
        Icon(imageVector = Icons.Filled.Star, contentDescription = "")
        Space(5,0)
        Text("Small Buttomn", fontSize = 30.sp)

    }
}

@Composable
fun Space(width: Int, height:Int){
    Spacer(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
    )
}