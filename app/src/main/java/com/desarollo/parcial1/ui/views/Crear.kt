package com.desarollo.parcial1.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.desarollo.parcial1.ui.viewmodels.ContactosViewModel

@Composable
fun CrearScreen(navHostController: NavHostController, contactosViewModel: ContactosViewModel) {
    Column {
        Row(modifier = Modifier.padding(5.dp)) {
            Button(onClick = {navHostController.navigate("Contactos")}) {
                Text("<")
            }
        }
        Column(modifier = Modifier
            .widthIn(395.dp, 500.dp)
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                contactosViewModel.contactInfo.plus("Camila Castañeda")
                navHostController.navigate("Contactos")

            }) {
                Text("Añadir")
            }
        }
    }
}