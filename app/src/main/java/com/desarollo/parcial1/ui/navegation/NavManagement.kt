package com.desarollo.parcial1.ui.navegation

import com.desarollo.parcial1.ui.viewmodels.DetallesViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.desarollo.parcial1.ui.viewmodels.ContactosViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.desarollo.parcial1.ui.views.ContactosScreen
import com.desarollo.parcial1.ui.views.DetallesScreen

@Composable
fun NavManagement() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Contactos") {
        composable("Contactos") {
            ContactosScreen(ContactosViewModel(),navController)
        }
        composable("Detalles") { backStackEntry ->

            val id = backStackEntry.arguments?.getString("contactoId")
            DetallesScreen(DetallesViewModel(), navController, id ?: "")
        }
    }
}
