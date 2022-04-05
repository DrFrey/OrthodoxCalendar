package com.example.orthodoxcalendar.common

import java.text.SimpleDateFormat
import java.util.*

fun Long?.convertLongToDate(format: String): String {
    if (this == 0L) return ""
    this?.let {
        kotlin.runCatching {
            val df = SimpleDateFormat(format, Locale.getDefault())
            return df.format(this)
        }
    }
    return ""
}

fun Date?.format(format: String): String {
    this?.let {
        val df = SimpleDateFormat(format, Locale.getDefault())
        return df.format(this)
    }
    return ""
}

const val D_MMMM = "d MMMM"
const val YYYY_MM_DD = "YYYY-MM-dd"