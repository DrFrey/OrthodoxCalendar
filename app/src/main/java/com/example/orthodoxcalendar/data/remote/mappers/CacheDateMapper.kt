package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.data.remote.model.CacheDateResponse
import com.example.orthodoxcalendar.data.storage.models.DateRuleLocal
import javax.inject.Inject

class CacheDateMapper @Inject constructor() {
    fun mapToLocal(cacheDateResponse: CacheDateResponse): List<DateRuleLocal> =
        with(cacheDateResponse) {
            return this.map { mapToDateRuleLocal(it) }
        }

    private fun mapToDateRuleLocal(cacheDateResponseItem: CacheDateResponse.CacheDateResponseItem): DateRuleLocal =
        with(cacheDateResponseItem.dateRule) {
            val additionalText = this?.additionalText?.map {
                DateRuleLocal.AdditionalText(
                    id = it?.id,
                    text = it?.text,
                    type = it?.type
                )
            }
            val holidays = this?.holidays?.map {
                DateRuleLocal.Holiday(
                    canonsOrAkathists = it?.canonsOrAkathists,
                    iconsOfHolidays = it?.iconsOfHolidays?.map { icon ->
                        DateRuleLocal.Holiday.IconsOfHoliday(
                            image = icon?.image
                        )
                    },
                    id = it?.id,
                    ideograph = it?.ideograph,
                    priority = it?.priority,
                    title = it?.title,
                    tropariaOrKontakia = it?.tropariaOrKontakia?.map { troparia ->
                        DateRuleLocal.Holiday.TropariaOrKontakia(
                            id = troparia?.id,
                            priority = troparia?.priority,
                            text = troparia?.text,
                            title = troparia?.title,
                            type = troparia?.type
                        )
                    },
                    uri = it?.uri
                )
            }
            val icons = this?.icons?.map {
                DateRuleLocal.Icon(
                    cleanTitle = it?.cleanTitle,
                    id = it?.id,
                    title = it?.title,
                    uri = it?.uri,
                    iconsOfOurLadyImgs = it?.iconsOfOurLadyImgs?.map { icon ->
                        DateRuleLocal.Icon.IconsOfOurLadyImg(
                            description = icon?.description,
                            id = icon?.id,
                            img = icon?.img,
                            priority = icon?.priority
                        )
                    }
                )
            }
            val saintsDatesStats = DateRuleLocal.SaintsDatesStats(
                group = this?.saintsDatesStats?.group,
                ideograph = this?.saintsDatesStats?.ideograph,
                number = this?.saintsDatesStats?.number,
                saints = this?.saintsDatesStats?.saints?.map { saint ->
                    DateRuleLocal.SaintsDatesStats.Saint(
                        description = saint?.description,
                        iconsOfSaints = saint?.iconsOfSaints?.map { icon ->
                            DateRuleLocal.SaintsDatesStats.Saint.IconsOfSaint(
                                image = icon?.image
                            )
                        },
                        id = saint?.id,
                        ideograph = saint?.ideograph,
                        suffixGroup = saint?.suffixGroup,
                        title = saint?.title,
                        titleGenitive = saint?.titleGenitive,
                        tropariaOrKontakia = saint?.tropariaOrKontakia?.map { troparia ->
                            DateRuleLocal.SaintsDatesStats.Saint.TropariaOrKontakia(
                                id = troparia?.id,
                                priority = troparia?.priority,
                                text = troparia?.text,
                                title = troparia?.title,
                                type = troparia?.type
                            )
                        },
                        uri = saint?.uri
                    )
                }
            )

            DateRuleLocal(
                additionalText = additionalText,
                holidays = holidays,
                icons = icons,
                id = this?.id,
                saintsDatesStats = saintsDatesStats
            )
        }

}