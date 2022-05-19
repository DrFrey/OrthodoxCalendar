package com.example.orthodoxcalendar.common

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class DateUtilsKtTest {

    private val testLong: Long = 1
    private val testDate: Date = Date(0L)
    private val wrongFormat = "ABCDef"

    @Test
    fun testConvertLongToDate() {
        assertEquals("", testLong.convertLongToDate(wrongFormat))
        assertEquals("1 января", testLong.convertLongToDate(D_MMMM))
        assertEquals("1970-01-01", testLong.convertLongToDate(YYYY_MM_DD))
    }

    @Test
    fun testFormatDate() {
        assertEquals("", testDate.format(wrongFormat))
        assertEquals("1 января", testDate.format(D_MMMM))
        assertEquals("1970-01-01", testDate.format(YYYY_MM_DD))
    }
}