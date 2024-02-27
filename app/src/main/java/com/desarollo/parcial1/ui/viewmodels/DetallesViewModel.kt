package com.desarollo.parcial1.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.desarollo.parcial1.models.Contacto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DetallesViewModel: ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val contactosRef = db.collection("contactos")

    suspend fun obtenerContactos(contactoId: String): Contacto? {
        return try {
            val snapshot = contactosRef.document(contactoId).get().await()
            snapshot.toObject(Contacto::class.java)
        } catch (e: Exception) {
            println("Error al obtener el contacto: ${e.message}")
            null
        }
    }

    fun editarContacto(
        contactoId: String,
        name: String,
        num: String,
        email: String,
        callback: (Contacto?) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            val oldContacto = obtenerContactos(contactoId)
            callback(oldContacto)

            if (oldContacto != null) {
                try {
                    val nuevoContacto = hashMapOf(
                        "Nombre" to name,
                        "Número de teléfono" to num,
                        "Correo electrónico" to email
                    )
                    contactosRef.document(contactoId).delete()
                    contactosRef.document(name).set(nuevoContacto)
                } catch (e: Exception) {
                    println("${e.message}")
                }
            }
        }
    }

    fun eliminarContacto(contactoId: String) {
        contactosRef.document(contactoId).delete()
    }
}