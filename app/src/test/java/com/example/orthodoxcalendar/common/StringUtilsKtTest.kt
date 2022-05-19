package com.example.orthodoxcalendar.common

import org.junit.Assert.*
import org.junit.Test

class StringUtilsKtTest {

    val testStringLower = "john"
    val testStringUpper = "Daenerys"
    @Test
    fun testTitlecaseFirstCharIfItIsLowercase() {
        assertEquals("John", testStringLower.titlecaseFirstCharIfItIsLowercase())
        assertEquals("Daenerys", testStringUpper.titlecaseFirstCharIfItIsLowercase())
    }
}