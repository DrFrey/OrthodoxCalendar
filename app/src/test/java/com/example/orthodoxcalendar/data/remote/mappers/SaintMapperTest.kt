package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.TestData
import org.junit.Assert.*
import org.junit.Test

class SaintMapperTest {

    @Test
    fun testSaintMapper() {

        val response = TestData.testSaintResponse
        val body = TestData.testSaintBody
        val icons = TestData.testIconsofSaint

        val saintMapper = SaintMapper()

        assertEquals(body, saintMapper.mapSaintBody(response))
        assertEquals(icons, saintMapper.mapSaintIcons(response.iconsOfSaints?.get(0)!!, 1))
    }
}