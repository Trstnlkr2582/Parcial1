package com.desarollo.parcial1.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.desarollo.parcial1.models.Contacto

class ContactosViewModel : ViewModel() {

    var contactInfo: MutableList<Contacto> = mutableListOf(Contacto("Camila",18,"a"))
}