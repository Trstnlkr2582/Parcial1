package com.desarollo.parcial1.ui.viewmodels

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desarollo.parcial1.ui.components.Contacto
import com.desarollo.parcial1.ui.components.Vacio

class ContactosViewModel: ViewModel() {
    var contactInfo: MutableList<String> = arrayOf()
}