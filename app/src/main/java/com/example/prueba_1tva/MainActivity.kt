package com.example.prueba_1tva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import com.example.prueba_1tva.navigations.NavManager
import com.example.prueba_1tva.ui.theme.ButtonFrirstAPPThere
import com.example.prueba_1tva.ui.theme.Prueba_1tvaTheme
import com.example.prueba_1tva.views.HomeView
import com.example.prueba_1tva.views.SmallButton
import com.example.prueba_1tva.views.Space
import com.google.ai.client.generativeai.common.shared.Content



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prueba_1tvaTheme{
                    NavManager()
                val smallButton = remember { mutableStateOf(false) }
                ButtonFrirstAPPThere(
                    smallTheme = smallButton.value,
                    dynamiscColor = false
                ){
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Content(
                            smallButton= smallButton,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        )

                    }
                }

            }

                }

            }


    @Composable
    fun Content(smallButton: MutableState<Boolean>, modifier: Modifier = Modifier){
        Column (
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SmallButton(="Haz Click!")
            Space(0,10)
            SmallFloatingActionButton()
        }
    }
}

