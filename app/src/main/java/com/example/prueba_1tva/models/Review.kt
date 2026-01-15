package com.example.prueba_1tva.models

import androidx.room.Entity
import org.w3c.dom.Comment

@Entity(tableName = "review")
data class Review(
    val id: String,
    val userId: String,
    val productCode: String,
    val rating: Int,
    val comment: Comment
){
    init {
        require(rating in 1 .. 5 ){"Rango de 1 a 5" }
    }
}


