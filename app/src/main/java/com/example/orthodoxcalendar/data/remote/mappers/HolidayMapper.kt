package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.data.remote.model.HolidayResponse
import com.example.orthodoxcalendar.data.storage.models.HolidayBody
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.IconsOfHoliday
import com.example.orthodoxcalendar.data.storage.models.TropariaOrKontakia
import javax.inject.Inject

class HolidayMapper @Inject constructor() {
    fun mapToLocal(
        body: HolidayResponse,
        icons: List<HolidayResponse.IconsOfHoliday>,
        troparia: List<HolidayResponse.TropariaOrKontakia>
    ): HolidayLocal = HolidayLocal(
        body = mapHolidayBody(body),
        icons = icons.map { mapHolidayIcons(it, body.id) },
        tropariaOrKontakia = troparia.map { mapHolidayTroparia(it, body.id) }
    )


    fun mapHolidayBody(body: HolidayResponse): HolidayBody =
        with(body) {
            HolidayBody(
                id = id,
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
        icons: HolidayResponse.IconsOfHoliday,
        holidayId: Int
    ): IconsOfHoliday = with(icons) {
        IconsOfHoliday(
            id = 0,
            holidayRelationId = holidayId,
            image = image.orEmpty()
        )
    }

    fun mapHolidayTroparia(
        troparia: HolidayResponse.TropariaOrKontakia,
        holidayId: Int
    ): TropariaOrKontakia = with(troparia) {
        TropariaOrKontakia(
            id = id,
            holidayRelationId = holidayId,
            audioSource = audioSource.orEmpty(),
            duration = duration ?: 0,
            priority = priority ?: 0,
            title = title.orEmpty(),
            type = type.orEmpty(),
            voice = voice.orEmpty()
        )
    }

}