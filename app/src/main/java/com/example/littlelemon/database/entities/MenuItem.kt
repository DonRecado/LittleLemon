package com.example.littlelemon.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuItem (
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String

)
