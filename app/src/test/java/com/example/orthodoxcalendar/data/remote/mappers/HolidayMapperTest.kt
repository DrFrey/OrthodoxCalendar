package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.TestData
import org.junit.Assert.*
import org.junit.Test

class HolidayMapperTest {

    @Test
    fun testHolidayMapper() {

        val response = TestData.testHolidayResponse
        val body = TestData.testHolidayBody
        val icons = TestData.testIconsOfHoliday

        val holidayMapper = HolidayMapper()

        assertEquals(body, holidayMapper.mapHolidayBody(response))
        assertEquals(icons, holidayMapper.mapHolidayIcons(response.iconsOfHolidays?.get(0)!!, 1))
    }
}