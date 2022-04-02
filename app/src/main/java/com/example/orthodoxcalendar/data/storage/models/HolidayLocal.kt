package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class HolidayLocal(
    @Embedded val body: HolidayBody,

    @Relation(
        parentColumn = "holidayId",
        entityColumn = "holidayRelationId"
    )
    val icons: List<IconsOfHoliday>,

    @Relation(
        parentColumn = "holidayId",
        entityColumn = "tropariaId",
        associateBy = Junction(HolidayTropariaCrossRef::class)
    )
    val troparia: List<TropariaOrKontakia>
)