package com.example.prueba_1tva.models

import androidx.room.Entity

@Entity(tableName = "Levelup")
class LevelUp (
    val id: String,
    val userId: String,
    val type: Transacion,
    val description: String

)


enum class Transacion{
    REFERRAL_BONUS,
    PURCHASE_BONUS,
    REVIEW_BONUS,
    PRODUCT_REDEMPTION,
    DISCOUNT_REDEMPTION,
    LEVEL_UP_BONUS
}

data class UserLevel(
    val level: Int,
    val pointsRequired: Int,
    val benefits: List<String>
) {
    companion object {
        fun getLevels(): List<UserLevel> = listOf(
            UserLevel(1, 0, listOf("Acceso básico a la tienda")),
            UserLevel(2, 100, listOf("Descuento del 5% en accesorios")),
            UserLevel(3, 300, listOf("Descuento del 10% en mouse y mousepads")),
            UserLevel(4, 600, listOf("Descuento del 15% en sillas gamers"))
        )
    }
}