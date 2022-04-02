package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TropariaOrKontakia(
    @PrimaryKey val tropariaId: Int,

    val audioSource: String,
    val duration: Int,
    val priority: Int,
    val title: String,
    val type: String,
    val voice: String
)