package com.example.orthodoxcalendar.domain.models

import com.example.orthodoxcalendar.data.remote.model.HolidayResponse

data class HolidayLocal(
    val id: Int,
    val canonsOrAkathists: List<String>,
    val daysAfter: Int,
    val daysBefore: Int,
    val description: String,
    val favorite: Boolean,
    val iconsOfHolidays: List<HolidayResponse.IconsOfHoliday>,
    val ideograph: Int,
    val liturgicalFeatures: String,
    val marked: Boolean,
    val pagetitle: String,
    val priority: Int,
    val temples: String,
    val theology: String,
    val title: String,
    val tropariaOrKontakia: List<HolidayResponse.TropariaOrKontakia>,
    val uri: String,
    val url: String,
    val urlBase: Int
)

data class IconsOfHoliday(
    val image: String
)

data class TropariaOrKontakia(
    val id: Int,
    val audioSource: String,
    val duration: Int,
    val priority: Int,
    val title: String,
    val type: String,
    val voice: String
)