package com.desarollo.parcial1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.desarollo.parcial1.models.Contacto
import com.desarollo.parcial1.ui.viewmodels.DetallesViewModel

@Composable
fun detalles(
    detallesViewModel: DetallesViewModel,
    contacto: Contacto,
    navController: NavController,
    contactoId: String
) {
    val showDialog = remember { mutableStateOf(false) }
    val showDeleteDialog = remember { mutableStateOf(false) }

    val onEditButtonClick: () -> Unit = {
        showDialog.value = true
    }
    val onDeleteButtonClick: () -> Unit = {
        showDeleteDialog.value = true
    }

    if (showDialog.value) {
        DialogoEditar(
            onDismiss = { showDialog.value = false },
            onSaveContact = { name, num, email ->
                detallesViewModel.editarContacto(contactoId, name, num, email) { }
                showDialog.value = false
            },
            contacto = contacto,
            navController = navController
        )
    }

    if (showDeleteDialog.value) {
        DialogoEliminar(
            onDismiss = { showDeleteDialog.value = false },
            onDeleteContact = {
                detallesViewModel.eliminarContacto(contactoId)
                showDeleteDialog.value = false
                navController.popBackStack()
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = contacto.name,
            Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = contacto.num.toString(),
            Modifier.padding(0.dp, 15.dp, 0.dp, 15.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
        Text(
            text = contacto.email,
            Modifier.padding(0.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )

        Box(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 15.dp)
                .fillMaxSize()
                .weight(0.8f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row {
                editarButton(onClick = onEditButtonClick)
                eliminarButton(onClick = onDeleteButtonClick)
            }
        }
    }
}

@Composable
fun editarButton(onClick: () -> Unit, icon: ImageVector = Icons.Rounded.Edit) {
    Button(onClick = onClick, Modifier.padding(0.dp, 0.dp, 30.dp, 0.dp)) {
        Icon(icon, contentDescription = null, modifier = Modifier.padding(15.dp, 0.dp, 15.dp, 0.dp))
        Text("Editar", fontSize = 20.sp)
    }
}

@Composable
fun eliminarButton(onClick: () -> Unit, icon: ImageVector = Icons.Rounded.Delete) {
    Button(onClick = onClick) {
        Icon(icon, contentDescription = null, modifier = Modifier.padding(15.dp, 0.dp, 15.dp, 0.dp))
        Text("Eliminar", fontSize = 20.sp)
    }
}

@Composable
fun DialogoEditar(
    onDismiss: () -> Unit,
    onSaveContact: (String, String, String) -> Unit,
    contacto: Contacto,
    navController: NavController
) {
    var name by remember { mutableStateOf(contacto.name) }
    var num by remember { mutableStateOf(contacto.num) }
    var email by remember { mutableStateOf(contacto.email) }

    Dialog(onDismissRequest = onDismiss) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black.copy(alpha = 0.8f))
                .padding(5.dp)
        )
        {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = num.toString(),
                    onValueChange = { num = it.toInt() },
                    label = { Text("Número") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    onSaveContact(name, num.toString(), email)
                    navController.popBackStack()
                }
                ) {
                    Text("Guardar")
                }
            }
        }
    }
}

@Composable
fun DialogoEliminar(
    onDismiss: () -> Unit,
    onDeleteContact: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black.copy(alpha = 0.8f))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "¿Estás seguro de que quieres eliminar este contacto?",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onDeleteContact) {
                        Text("Confirmar")
                    }
                    Button(onClick = onDismiss) {
                        Text("Cancelar")
                    }
                }
            }
        }
    }
}