package com.desarollo.parcial1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.desarollo.parcial1.models.Contacto

@Composable
fun lista(navController: NavController, contactos: List<Contacto>) {
    LazyColumn {
        items(contactos) { contacto ->
            Contacto(navController = navController, contacto = contacto)
        }
    }
}

@Composable
fun Contacto(navController: NavController, contacto: Contacto) {
    Column(modifier = Modifier
        .padding(20.dp, 10.dp, 20.dp, 0.dp)
        .clickable { navController.navigate("Detalles/${contacto.name}") }
        .fillMaxWidth()
        .background(Color(237, 244, 244), shape = RoundedCornerShape(5.dp))
    ) {
        Box(modifier = Modifier.padding(10.dp)) {
            Column {
                Row {
                    Column {
                        Text(contacto.name, fontWeight = FontWeight.Bold)
                        Text("${contacto.num}")
                    }
                }
            }
        }
    }
}
@Composable
fun BotonAgregar(onClick: () -> Unit, icon: ImageVector = Icons.Rounded.Add) {
    Button(onClick = onClick, modifier = Modifier.padding(15.dp)) {
        Icon(icon, contentDescription = null, modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
        Text(text = "Agregar Contacto", fontSize = 18.sp)
    }
}

@Composable
fun Dialogo(onDismiss: () -> Unit, onSaveContact: (String, String, String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var num by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(79, 118, 209))
                .padding(5.dp)
        )
        {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .width(IntrinsicSize.Max)
            ) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = num,
                    onValueChange = { num = it },
                    label = { Text("Número de teléfono") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo electrónico") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onSaveContact(name, num, email) }) {
                    Text("Guardar Contacto")
                }
            }
        }
    }
}