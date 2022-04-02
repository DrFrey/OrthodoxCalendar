package com.example.orthodoxcalendar.data.remote.mappers

import com.example.orthodoxcalendar.common.titlecaseFirstCharIfItIsLowercase
import com.example.orthodoxcalendar.data.remote.model.DayResponse
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import javax.inject.Inject

class DayMapper @Inject constructor() {
    fun mapToLocal(dayResponse: DayResponse): DayLocal =
        with(dayResponse) {
            val fastings = fastings?.map {
                DayLocal.Fasting(
                    description = it?.description.orEmpty(),
                    fasting = it?.fasting.orEmpty(),
                    roundWeek = it?.roundWeek.orEmpty(),
                    separator = it?.separator.orEmpty(),
                    type = it?.type,
                    voice = it?.voice,
                    weeks = it?.weeks.orEmpty()
                )
            }
            val holidays = holidays?.map {
                DayLocal.Holiday(
                    datepickerClass = it?.datepickerClass.orEmpty(),
                    daysAfter = it?.daysAfter,
                    daysBefore = it?.daysBefore,
                    favorite = it?.favorite,
                    fullTitle = it?.fullTitle.orEmpty(),
                    iconography = it?.iconography.orEmpty(),
                    id = it?.id ?: -1,
                    ideograph = it?.ideograph,
                    imgs = it?.imgs?.map { img ->
                        DayLocal.Holiday.Img(
                            description = img?.description.orEmpty(),
                            holidayId = img?.holidayId,
                            id = img?.id,
                            image = img?.image.orEmpty(),
                            priority = img?.priority,
                            preview = img?.preview.orEmpty()
                        )
                    },
                    liturgicalFeatures = it?.liturgicalFeatures.orEmpty(),
                    marked = it?.marked,
                    metaDescription = it?.metaDescription.orEmpty(),
                    pagetitle = it?.pagetitle.orEmpty(),
                    priority = it?.priority,
                    temples = it?.temples.orEmpty(),
                    theology = it?.theology.orEmpty(),
                    title = it?.title.orEmpty(),
                    uri = it?.uri.orEmpty(),
                    url = it?.url.orEmpty(),
                    urlBase = it?.urlBase
                )
            }
            val icons = ikons?.map {
                DayLocal.Icon(
                    bold = it?.bold,
                    cleanTitle = it?.cleanTitle.orEmpty(),
                    date = it?.date.orEmpty(),
                    hide = it?.hide,
                    iconography = it?.iconography.orEmpty(),
                    id = it?.id,
                    ideograph = it?.ideograph,
                    imgs = it?.imgs?.map { img ->
                        DayLocal.Icon.Img(
                            description = img?.description.orEmpty(),
                            iconOfOurLadyId = img?.iconOfOurLadyId,
                            id = img?.id,
                            img = img?.img.orEmpty(),
                            priority = img?.priority
                        )
                    },
                    liturgicalFeatures = it?.liturgicalFeatures.orEmpty(),
                    metaDescription = it?.metaDescription.orEmpty(),
                    number = it?.number,
                    _number = it?._number,
                    temples = it?.temples.orEmpty(),
                    theology = it?.theology.orEmpty(),
                    title = it?.title.orEmpty(),
                    uri = it?.uri.orEmpty()
                )
            }
            val saints = saints?.map {
                DayLocal.Saint(
                    bold = it?.bold,
                    churchTitle = it?.churchTitle.orEmpty(),
                    churchTitlePlural = it?.churchTitlePlural.orEmpty(),
                    combinedGroup = it?.combinedGroup,
                    dateId = it?.dateId,
                    enableChurchTitle = it?.enableChurchTitle,
                    enableTypeOfSanctity = it?.enableTypeOfSanctity,
                    group = it?.group,
                    hideIdeograph = it?.hideIdeograph,
                    id = it?.id,
                    ideograph = it?.ideograph,
                    imgs = it?.imgs?.map { img ->
                        DayLocal.Saint.Img(
                            description = img?.description.orEmpty(),
                            id = img?.id,
                            image = img?.image.orEmpty(),
                            onlyMain = img?.onlyMain,
                            preview = img?.preview.orEmpty(),
                            priority = img?.priority,
                            saintId = img?.saintId,
                            title = img?.title.orEmpty()
                        )
                    },
                    isCathedral = it?.isCathedral,
                    linkToService = it?.linkToService.orEmpty(),
                    name = it?.name.orEmpty(),
                    newmartyr = it?.newmartyr,
                    number = it?.number,
                    prefix = it?.prefix.orEmpty(),
                    priority = it?.priority,
                    saintsDatesStatsFltr = it?.saintsDatesStatsFltr,
                    sex = it?.sex.orEmpty(),
                    splitGroup = it?.splitGroup,
                    title = it?.title.orEmpty(),
                    typeOfSanctityComplete = it?.typeOfSanctityComplete.orEmpty(),
                    typeOfSanctityCompleteFemale = it?.typeOfSanctityCompleteFemale.orEmpty(),
                    typeOfSanctityPlural = it?.typeOfSanctityPlural.orEmpty(),
                    union = it?.union.orEmpty(),
                    uri = it?.uri.orEmpty(),
                    url = it?.url.orEmpty(),
                    worldlyActivities = it?.worldlyActivities.orEmpty(),
                    generatedText = generateSaintText(
                        it?.typeOfSanctity.orEmpty(),
                        it?.titleGenitive.orEmpty(),
                        it?.churchTitleGenitive.orEmpty(),
                        it?.suffix.orEmpty()
                    )
                )
            }
            val texts = texts?.map {
                DayLocal.Text(
                    dateType = it?.dateType,
                    refs = it?.refs,
                    text = it?.text.orEmpty(),
                    type = it?.type
                )
            }

            DayLocal(
                fastings = fastings.orEmpty(),
                holidays = holidays.orEmpty(),
                icons = icons.orEmpty(),
                saints = saints.orEmpty(),
                texts = texts.orEmpty()
            )
        }

    private fun generateSaintText(
        type: String,
        titleGenitive: String,
        churchTitleGenitive: String,
        suffix: String
    ): String {
        val result = StringBuilder()
        if (type.isNotEmpty()) {
            result.append(type.titlecaseFirstCharIfItIsLowercase())
        }
        if (titleGenitive.isNotEmpty()) {
            result.append(" $titleGenitive")
        }
        if (churchTitleGenitive.isNotEmpty()) {
            result.append(", $churchTitleGenitive")
        }
        if (suffix.isNotEmpty()) {
            result.append(" $suffix")
        }
        return result.toString()
    }
}