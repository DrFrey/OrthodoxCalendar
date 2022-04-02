package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.data.remote.model.TropariaOrKontakiaResponse
import com.example.orthodoxcalendar.data.storage.models.TropariaOrKontakia
import javax.inject.Inject

class TropariaMapper @Inject constructor() {
    fun mapTroparia(
        troparia: TropariaOrKontakiaResponse
        ): TropariaOrKontakia = with(troparia) {
        TropariaOrKontakia(
            tropariaId = id,
            audioSource = audioSource.orEmpty(),
            duration = duration ?: 0,
            priority = priority ?: 0,
            title = title.orEmpty(),
            type = type.orEmpty(),
            voice = voice.orEmpty()
        )
    }
}