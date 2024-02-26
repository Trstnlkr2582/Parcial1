package com.desarollo.parcial1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Contacto(b:String,function: () -> Unit) {
    val info = b.split(",")
    val name = info[0]
    Row(modifier = Modifier
        .widthIn(180.dp, 500.dp)
        .height(50.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color(144, 188, 245))
        .padding(horizontal = 20.dp)
        .clickable { function() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        Text(name, fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun Vacio() {
    Row(modifier = Modifier
        .widthIn(180.dp, 500.dp)
        .height(50.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color(182, 195, 214))
        .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("Tu lista de contactos está vacia", fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun ListaContactos(a: Array<String>, function: () -> Unit) {
    Column {
        if (a.isNotEmpty()) {
            for (element in a) {
                Contacto(element) {
                    function()
                }
            }
        }
        else {
            Vacio()
        }
    }
}