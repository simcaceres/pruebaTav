package com.example.prueba_1tva.models

import androidx.room.Entity


@Entity(tableName = "producto")
data class Producto(
    val codigo: String,
    val nombre: String,
    val categoria: String,
    val stock: Int = 0,
    val precio: Double
){
    val formatoDePreccio: String
        get() = "${String.format("%", precio)}"

    val isStock: Boolean
        get() = stock > 0
}


enum class ProductCategory(val displayName: String) {
    BOARD_GAMES("Juegos de Mesa"),
    ACCESSORIES("Accesorios"),
    CONSOLES("Consolas"),
    GAMER_PCS("Computadores Gamers")

}
