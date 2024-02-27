package com.desarollo.parcial1.models

data class Contacto(
    val name: String,
    val num: String,
    val email: String
) {
    constructor() : this("","","")

}