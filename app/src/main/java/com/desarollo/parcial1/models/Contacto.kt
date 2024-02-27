package com.desarollo.parcial1.models

data class Contacto(
    val name: String,
    val num: Int,
    val email: String
) {
    constructor() : this("",0,"")

}