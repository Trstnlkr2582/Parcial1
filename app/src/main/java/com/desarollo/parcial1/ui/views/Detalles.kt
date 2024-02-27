package com.desarollo.parcial1.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DetallesScreen(navHostController: NavHostController) {

    Row(modifier = Modifier.padding(5.dp)) {
        Button(onClick = {navHostController.navigate("Contactos")}) {
            Text("<")
        }

    }
}