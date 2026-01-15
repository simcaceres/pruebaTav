package com.example.prueba_1tva.models

import androidx.room.Entity
import java.time.LocalDate


@Entity(tableName = "Usuario")
data class Usuario (

    val id: Int = 0,
    val nombre: String = "",
    val apellido: String = "",
    val email : String = "",
    val password : String = "",
    val direccion : String? = "",
    val phone : String = ""
){
    val fullName: String
        get() = "$nombre $apellido"


}