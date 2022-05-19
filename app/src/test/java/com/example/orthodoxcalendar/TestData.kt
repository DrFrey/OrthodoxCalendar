package com.example.orthodoxcalendar

import com.example.orthodoxcalendar.data.remote.model.HolidayResponse
import com.example.orthodoxcalendar.data.remote.model.SaintResponse
import com.example.orthodoxcalendar.data.remote.model.TropariaOrKontakiaResponse
import com.example.orthodoxcalendar.data.storage.models.*

object TestData {

    val testTropariaOrKontakia = TropariaOrKontakia(
        1, "", 1,
        0, "test title", "", ""
    )

    val testHolidayResponse = HolidayResponse(
        listOf(), 0, 0, "test holiday", false,
        listOf(HolidayResponse.IconsOfHoliday("testUrl")), 1, 0, "",
        false, "test", 0, "", "", "test",
        listOf(TropariaOrKontakiaResponse("", 1, 1, 0, "test title", null, null)),
        "", "", 0
    )

    val testHolidayBody = HolidayBody(
        1, listOf(), 0, 0, "test holiday",
        false, 0, "", false, "test", 0,
        "", "", "test", "", "", 0
    )

    val testIconsOfHoliday = IconsOfHoliday(0, 1, "testUrl")

    val testSaintResponse = SaintResponse(
        "test saint", false, false, 1, listOf(SaintResponse.IconsOfSaint("testUrl")),
        1, 0, false, false, "", false, 0, "",
        false, false, "", null, null, null, null,
        listOf(TropariaOrKontakiaResponse("", 1, 1, 0, "test title", null, null)),
        "", "", "", ""
    )

    val testSaintBody = SaintBody(
        1, "test saint", false, false,
        1, 0, false, false, "", false,
        0, "", false, false, "", "",
        "", "", "", "", "", "", ""
    )

    val testIconsofSaint = IconsOfSaint(
        0, 1, "testUrl"
    )
}