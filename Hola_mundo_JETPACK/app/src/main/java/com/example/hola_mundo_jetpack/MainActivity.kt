package com.example.hola_mundo_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hola_mundo_jetpack.ui.theme.Hola_mundo_jetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hola_mundo_jetpackTheme {
                  Greeting(
                    name = "Android",
                    modifier = Modifier.fillMaxSize()
                ) }

            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var  texto_escrito_por_el_susuario = remember{ mutableStateOf("Texto place holder") }
    var saludar_a= remember { mutableStateOf("mundo") }
    Column(
        modifier=modifier,
        VerticalArrangment = Arrangement.Center,
        HorizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "Hello ${""}!",
            modifier = modifier
        )

        OutlinedTextField(
            value=texto_escrito_por_el_susuario.value,
            onValueChange ={ texto_introducido_por_el_usuario->
                texto_escrito_por_el_susuario.value = texto_introducido_por_el_usuario
                //pasar a hacer cosas
            }
        )

        Button(
            onClick={
                if (texto_escrito_por_el_susuario.value == ""){
                    saludar_a.value = "mundo"
                }
                else{
                    saludar_a.value = texto_escrito_por_el_susuario.value
                    texto_escrito_por_el_susuario.value = ""
                }
            }
        ){
            Text("pulsame")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hola_mundo_jetpackTheme {
        Greeting("Android")
    }
}