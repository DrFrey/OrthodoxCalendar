package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.TestData
import org.junit.Assert.*
import org.junit.Test

class TropariaMapperTest {

    @Test
    fun testTropariaMapper() {
        val saintResponse = TestData.testSaintResponse
        val holidayResponse = TestData.testHolidayResponse
        val troparia = TestData.testTropariaOrKontakia

        val tropariaMapper = TropariaMapper()

        assertEquals(troparia, tropariaMapper.mapTroparia(saintResponse.tropariaOrKontakia?.get(0)!!))
        assertEquals(troparia, tropariaMapper.mapTroparia(holidayResponse.tropariaOrKontakia?.get(0)!!))
    }
}