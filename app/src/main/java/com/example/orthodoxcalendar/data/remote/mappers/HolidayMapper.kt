package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.data.remote.model.HolidayResponse
import com.example.orthodoxcalendar.data.storage.models.HolidayBody
import com.example.orthodoxcalendar.data.storage.models.IconsOfHoliday
import javax.inject.Inject

class HolidayMapper @Inject constructor() {

    fun mapHolidayBody(body: HolidayResponse): HolidayBody =
        with(body) {
            HolidayBody(
                holidayId = id,
                canonsOrAkathists = canonsOrAkathists ?: listOf(),
                daysAfter = daysAfter ?: 0,
                daysBefore = daysBefore ?: 0,
                description = description.orEmpty(),
                favorite = favorite ?: false,
                ideograph = ideograph ?: 0,
                liturgicalFeatures = liturgicalFeatures.orEmpty(),
                marked = marked ?: false,
                pagetitle = pagetitle.orEmpty(),
                priority = priority ?: 0,
                temples = temples.orEmpty(),
                theology = theology.orEmpty(),
                title = title.orEmpty(),
                uri = uri.orEmpty(),
                url = url.orEmpty(),
                urlBase = urlBase ?: 0
            )
        }

    fun mapHolidayIcons(
        icon: HolidayResponse.IconsOfHoliday,
        holidayId: Int
    ): IconsOfHoliday = with(icon) {
        IconsOfHoliday(
            id = 0,
            holidayRelationId = holidayId,
            image = image.orEmpty()
        )
    }
}