package com.example.orthodoxcalendar.common

import java.util.*

fun String.titlecaseFirstCharIfItIsLowercase() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}