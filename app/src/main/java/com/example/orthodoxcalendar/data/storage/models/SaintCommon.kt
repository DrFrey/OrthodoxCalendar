package com.example.orthodoxcalendar.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SaintBody(
    @PrimaryKey val saintId: Int,

    val description: String,
    val enableChurchTitleGroup: Boolean,
    val enableTypeOfSanctityGroup: Boolean,
    val group: Int,
    val ideograph: Int,
    val isCathedral: Boolean,
    val isMenologyRpc: Boolean,
    val linkToService: String,
    val newmartyr: Boolean,
    val number: Int,
    val prefixGroup: String,
    val priority: Boolean,
    val skipInMenology: Boolean,
    val suffixGroup: String,
    val temples: String,
    val title: String,
    val titleGenitive: String,
    val titleGroup: String,
    val unionGroup: String,
    val uri: String,
    val url: String,
    val worldlyActivities: String
)

@Entity
data class IconsOfSaint(
    @PrimaryKey(autoGenerate = true) val id: Int,

    val saintRelationId: Int,
    val image: String
    )