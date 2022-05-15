package com.example.orthodoxcalendar.data.storage.dao

import androidx.room.*
import com.example.orthodoxcalendar.data.storage.models.*

@Dao
interface HolidayDao {

    @Transaction
    @Query("SELECT * FROM HolidayBody")
    suspend fun getAllHolidays(): List<HolidayLocal>

    @Transaction
    @Query("SELECT * FROM HolidayBody WHERE holidayId = :id")
    suspend fun getHolidayById(id: Int): HolidayLocal

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHolidayInTransaction(
        body: HolidayBody,
        icons: List<IconsOfHoliday>,
        troparia: List<TropariaOrKontakia>
    ) {
        insertHoliday(body)
        insertIcons(icons)
        insertTroparia(troparia)
        for (item in troparia) {
            insertCrossRef(HolidayTropariaCrossRef(holidayId = body.holidayId, tropariaId = item.tropariaId))
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoliday(body: HolidayBody): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIcons(icons: List<IconsOfHoliday>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTroparia(troparia: List<TropariaOrKontakia>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCrossRef(cross: HolidayTropariaCrossRef)
}