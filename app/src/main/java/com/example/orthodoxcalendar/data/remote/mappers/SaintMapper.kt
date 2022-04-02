package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.data.remote.model.SaintResponse
import com.example.orthodoxcalendar.data.storage.models.IconsOfSaint
import com.example.orthodoxcalendar.data.storage.models.SaintBody
import javax.inject.Inject

class SaintMapper @Inject constructor() {

    fun mapSaintBody(body: SaintResponse): SaintBody =
        with(body) {
            SaintBody(
                saintId = id,
                description = description.orEmpty(),
                enableChurchTitleGroup = enableChurchTitleGroup ?: true,
                enableTypeOfSanctityGroup = enableTypeOfSanctityGroup ?: true,
                group = group ?: 0,
                ideograph = ideograph ?: 0,
                isCathedral = isCathedral ?: false,
                isMenologyRpc = isMenologyRpc ?: true,
                linkToService = linkToService.orEmpty(),
                newmartyr = newmartyr ?: false,
                number = number ?: 0,
                prefixGroup = prefixGroup.orEmpty(),
                priority = priority ?: true,
                skipInMenology = skipInMenology ?: false,
                suffixGroup = suffixGroup.orEmpty(),
                temples = temples.orEmpty(),
                title = title.orEmpty(),
                titleGenitive = titleGenitive.orEmpty(),
                titleGroup = titleGroup.orEmpty(),
                unionGroup = unionGroup.orEmpty(),
                uri = uri.orEmpty(),
                url = url.orEmpty(),
                worldlyActivities = worldlyActivities.orEmpty()
            )
        }

    fun mapSaintIcons(
        icon: SaintResponse.IconsOfSaint,
        saintId: Int
        ): IconsOfSaint = with(icon) {
            IconsOfSaint(
                id = 0,
                saintRelationId = saintId,
                image = image.orEmpty()
            )
        }
}