package com.desarollo.parcial1.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.desarollo.parcial1.models.Contacto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class ContactosViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val contactosRef = db.collection("contactos")

    fun agregarContacto(name: String, num: String, email: String) {
        try {
            val nuevoContacto = hashMapOf(
                "name" to name,
                "num" to num,
                "email" to email
            )
            contactosRef.document(name).set(nuevoContacto)
        } catch (e: Exception) {
            println("${e.message}")
        }
    }

    fun obtenerContactos(): Flow<List<Contacto>> = flow {
        try {
            val snapshot = contactosRef.get().await()
            val contactos = snapshot.documents.mapNotNull { document ->
                document.toObject(Contacto::class.java)
            }
            emit(contactos)
        } catch (e: Exception) {
            println("${e.message}")
        }
    }
}