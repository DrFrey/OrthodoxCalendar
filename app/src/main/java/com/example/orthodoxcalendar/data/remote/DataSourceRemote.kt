package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.common.request
import com.example.orthodoxcalendar.data.remote.mappers.DayMapper
import com.example.orthodoxcalendar.data.remote.mappers.HolidayMapper
import com.example.orthodoxcalendar.data.remote.mappers.SaintMapper
import com.example.orthodoxcalendar.data.remote.mappers.TropariaMapper
import com.example.orthodoxcalendar.data.repository.Result
import com.example.orthodoxcalendar.data.repository.map
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.SaintLocal
import javax.inject.Inject

class DataSourceRemote @Inject constructor(
    private val calendarApiService: CalendarApiService,
    private val dayMapper: DayMapper,
    private val holidayMapper: HolidayMapper,
    private val tropariaMapper: TropariaMapper,
    private val saintMapper: SaintMapper
) {

    suspend fun getDay(date: String): Result<DayLocal> =
        request {
            calendarApiService.getDay(date)
        }.map {
            dayMapper.mapToLocal(it)
        }

    suspend fun getHoliday(id: Int): Result<HolidayLocal> =
        request {
            calendarApiService.getHoliday(id)
        }.map { response ->
            HolidayLocal(
                body = holidayMapper.mapHolidayBody(response),
                icons = response.iconsOfHolidays?.map { icon ->
                    holidayMapper.mapHolidayIcons(icon, response.id)
                } ?: listOf(),
                troparia = response.tropariaOrKontakia?.map { troparia ->
                    tropariaMapper.mapTroparia(troparia)
                } ?: listOf()
            )
        }

    suspend fun getSaint(id: Int): Result<SaintLocal> =
        request {
            calendarApiService.getSaint(id)
        }.map { response ->
            SaintLocal(
                body = saintMapper.mapSaintBody(response),
                icons = response.iconsOfSaints?.map { icon ->
                    saintMapper.mapSaintIcons(icon, response.id)
                } ?: listOf(),
                troparia = response.tropariaOrKontakia?.map { troparia ->
                    tropariaMapper.mapTroparia(troparia)
                } ?: listOf()
            )
        }
}