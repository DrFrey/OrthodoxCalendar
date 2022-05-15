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
        entity = TropariaOrKontakia::class,
        entityColumn = "tropariaId",
        associateBy = Junction(
            value = HolidayTropariaCrossRef::class,
            parentColumn = "holidayId",
            entityColumn = "tropariaId"
        )
    )
    val troparia: List<TropariaOrKontakia>
)