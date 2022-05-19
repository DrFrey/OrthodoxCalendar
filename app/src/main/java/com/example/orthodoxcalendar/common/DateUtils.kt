package com.example.orthodoxcalendar.common

import java.text.SimpleDateFormat
import java.util.*

fun Long?.convertLongToDate(format: String): String {
    if (this == 0L || this == null) return ""
    return try {
        val df = SimpleDateFormat(format, Locale.getDefault())
        df.format(this)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun Date?.format(format: String): String {
    if (this == null) return ""
    return try {
        val df = SimpleDateFormat(format, Locale.getDefault())
        df.format(this)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
        ""
    }
}

const val D_MMMM = "d MMMM"
const val YYYY_MM_DD = "YYYY-MM-dd"