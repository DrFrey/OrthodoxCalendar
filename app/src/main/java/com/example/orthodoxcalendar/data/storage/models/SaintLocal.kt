package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SaintLocal(
    @Embedded val body: SaintBody,

    @Relation(
        parentColumn = "saintId",
        entityColumn = "saintRelationId"
    )
    val icons: List<IconsOfSaint>,

    @Relation(
        parentColumn = "saintId",
        entityColumn = "tropariaId",
        associateBy = Junction(SaintTropariaCrossRef::class)
    )
    val troparia: List<TropariaOrKontakia>
)