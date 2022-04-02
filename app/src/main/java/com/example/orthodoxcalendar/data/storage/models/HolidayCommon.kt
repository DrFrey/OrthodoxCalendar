package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HolidayBody(
    @PrimaryKey val holidayId: Int,

    val canonsOrAkathists: List<String>,
    val daysAfter: Int,
    val daysBefore: Int,
    val description: String,
    val favorite: Boolean,
    val ideograph: Int,
    val liturgicalFeatures: String,
    val marked: Boolean,
    val pagetitle: String,
    val priority: Int,
    val temples: String,
    val theology: String,
    val title: String,
    val uri: String,
    val url: String,
    val urlBase: Int
    )

@Entity
data class IconsOfHoliday(
    @PrimaryKey(autoGenerate = true) val id: Int,

    val holidayRelationId: Int,
    val image: String
    )