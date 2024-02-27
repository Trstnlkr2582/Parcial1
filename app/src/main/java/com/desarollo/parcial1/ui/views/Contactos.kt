package com.desarollo.parcial1.ui.views

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.desarollo.parcial1.ui.components.ListaContactos
import com.desarollo.parcial1.ui.viewmodels.ContactosViewModel

@Composable
fun ContactosScreen(navHostController: NavHostController, contactosViewModel: ContactosViewModel) {
    Column(modifier = Modifier
        .verticalScroll(state = ScrollState(0))
        .widthIn(395.dp, 500.dp)
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(25.dp)) {
            Text("Contactos", fontSize = 35.sp)
        }
        ListaContactos(contactosViewModel.contactInfo) {
            navHostController.navigate("Detalles")
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Button(onClick = {navHostController.navigate("Crear")}) {
                Text("Añadir Contacto")
            }
        }
    }
}