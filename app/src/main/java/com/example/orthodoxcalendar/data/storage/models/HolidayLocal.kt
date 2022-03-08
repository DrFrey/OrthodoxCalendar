package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Embedded
import androidx.room.Relation

data class HolidayLocal(
    @Embedded val body: HolidayBody,
    @Relation(
        parentColumn = "id",
        entityColumn = "holidayRelationId"
    )
    val icons: List<IconsOfHoliday>,
    @Relation(
        parentColumn = "id",
        entityColumn = "holidayRelationId"
    )
    val tropariaOrKontakia: List<TropariaOrKontakia>
)