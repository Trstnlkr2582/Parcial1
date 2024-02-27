package com.desarollo.parcial1.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.desarollo.parcial1.ui.viewmodels.ContactosViewModel
import com.desarollo.parcial1.ui.views.ContactosScreen
import com.desarollo.parcial1.ui.views.CrearScreen
import com.desarollo.parcial1.ui.views.DetallesScreen
import com.desarollo.parcial1.ui.views.EditarScreen

@Composable
fun NavManagement() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Contactos") {
        composable("Contactos") {
            ContactosScreen(navController,ContactosViewModel())
        }
        composable("Crear") {
            CrearScreen(navController,ContactosViewModel())
        }
        composable("Detalles") {
            DetallesScreen(navController)
        }
        composable("Editar") {
            EditarScreen(navController)
        }
    }
}
