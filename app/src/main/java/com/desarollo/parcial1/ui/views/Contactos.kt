package com.desarollo.parcial1.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.desarollo.parcial1.ui.components.BotonAgregar
import com.desarollo.parcial1.ui.components.Dialogo
import com.desarollo.parcial1.ui.components.lista
import com.desarollo.parcial1.ui.viewmodels.ContactosViewModel

@Composable
fun ContactosScreen(contactosViewModel: ContactosViewModel, navController: NavController) {
    val showAddContactDialog = remember { mutableStateOf(false) }
    val contactosState by contactosViewModel.obtenerContactos().collectAsState(initial = emptyList())

    Column {
        Text(
            text = "Contactos",
            modifier = Modifier.padding(15.dp),
            fontSize = 25.sp
        )
        Box(
            Modifier
                .fillMaxWidth()
                .weight(0.9f)
        ) {
            lista(navController, contactosState)
        }

        Box(
            Modifier
                .fillMaxSize()
                .weight(0.1f),
            contentAlignment = Alignment.BottomCenter
        ) {

            BotonAgregar(onClick = { showAddContactDialog.value = true })
        }

        if (showAddContactDialog.value) {
            Dialogo(
                onDismiss = { showAddContactDialog.value = false },
                onSaveContact = { name, num, email ->
                    contactosViewModel.agregarContacto(name, num, email)
                    showAddContactDialog.value = false
                }
            )
        }
    }
}