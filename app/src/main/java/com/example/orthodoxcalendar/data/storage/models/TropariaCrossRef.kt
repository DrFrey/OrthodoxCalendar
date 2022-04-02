package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Entity

@Entity(primaryKeys = ["holidayId", "tropariaId"])
data class HolidayTropariaCrossRef(
    val holidayId: Int,
    val tropariaId: Int
)

@Entity(primaryKeys = ["saintId", "tropariaId"])
data class SaintTropariaCrossRef(
    val saintId: Int,
    val tropariaId: Int
)
