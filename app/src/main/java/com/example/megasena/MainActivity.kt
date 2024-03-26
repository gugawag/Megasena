package com.example.megasena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.megasena.modelo.MegaSena
import com.example.megasena.ui.theme.MegasenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MegasenaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumerosSena()
                }
            }
        }
    }
}

@Composable
fun NumerosSena(modifier: Modifier = Modifier) {
    val megaSena = MegaSena()
    var serieApostada by remember { mutableStateOf("") }
    var mostrarNumeros by remember { mutableStateOf(false) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = serieApostada.toString(), onValueChange = {serieApostada = it}, label = { Text("Valor Apostado") }, placeholder = { Text("Digite os números separados por ,") })
        Button(onClick = {
            mostrarNumeros = true
        }) {
            Text("Verificar números")
        }
        if (mostrarNumeros) {
            var corAtual = Color.Black
            Row {
                val numerosApostados = serieApostada.split(",").map { it.toInt() }
                for (numero in megaSena.numeros) {
                    if (numerosApostados.contains(numero)) {
                        corAtual = Color.Blue
                    }
                    Text(
                        text = numero.toString() + ',',
                        color = corAtual,
                        modifier = modifier
                    )
                    corAtual = Color.Black
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApostaPreview() {
    MegasenaTheme {
        NumerosSena()
    }
}