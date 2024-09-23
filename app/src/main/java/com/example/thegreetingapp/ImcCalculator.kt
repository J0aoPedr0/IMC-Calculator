package com.example.thegreetingapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculoImc() {
    var textWeight by remember { mutableStateOf("") }
    var textHeight by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))

    ) {
        Text(
            text = "Calculadora de IMC!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 170.dp),
            text = "Informe seu Peso [KG]",
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 30.sp
            )
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp),
            value = textWeight, onValueChange = { newText -> textWeight = newText },
            label = { Text("Seu peso aqui!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
                    },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
            )

        Text(
            text = "Informe sua Altura (Coloque Metro e Cm)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 50.dp, end = 50.dp),
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 30.sp
            )
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp),
            value = textHeight, onValueChange = { newText -> textHeight = newText },
            label = { Text("Sua altura aqui!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Button(onClick = { Toast.makeText(context, "O seu IMC é ${textWeight.toFloat() / (textHeight.toFloat() * textHeight.toFloat())}", Toast.LENGTH_SHORT).show()},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 50.dp, end = 50.dp)) {
            Text(text = "Calcular")
        }
            
    }
}














@Preview
@Composable
fun CalculoImcPreview() {
    CalculoImc()
}