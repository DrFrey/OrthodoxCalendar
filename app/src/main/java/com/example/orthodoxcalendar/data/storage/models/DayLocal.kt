package com.example.orthodoxcalendar.data.storage.models

class DayLocal(
    val fastings: List<Fasting>,
    val holidays: List<Holiday>,
    val icons: List<Icon>,
    val saints: List<Saint>,
    val texts: List<Text>
) {
    data class Fasting(
        val description: String,
        val fasting: String,
        val roundWeek: String,
        val separator: String,
        val type: Int?,
        val voice: Int?,
        val weeks: String
    )

    data class Holiday(
        val datepickerClass: String,
        val daysAfter: Int?,
        val daysBefore: Int?,
        val favorite: Int?,
        val fullTitle: String,
        val iconography: String,
        val id: Int,
        val ideograph: Int?,
        val imgs: List<Img?>?,
        val liturgicalFeatures: String,
        val marked: Int?,
        val metaDescription: String,
        val pagetitle: String,
        val priority: Int?,
        val temples: String,
        val theology: String,
        val title: String,
        val uri: String,
        val url: String,
        val urlBase: Int?
    ) {
        data class Img(
            val description: String,
            val holidayId: Int?,
            val id: Int?,
            val image: String,
            val priority: Int?,
            val preview: String
        )
    }

    data class Icon(
        val bold: Int?,
        val cleanTitle: String,
        val date: String,
        val hide: Int?,
        val iconography: String,
        val id: Int?,
        val ideograph: Int?,
        val imgs: List<Img?>?,
        val liturgicalFeatures: String,
        val metaDescription: String,
        val number: Int?,
        val _number: Int?,
        val temples: String,
        val theology: String,
        val title: String,
        val uri: String
    ) {
        data class Img(
            val description: String,
            val iconOfOurLadyId: Int?,
            val id: Int?,
            val img: String,
            val priority: Int?
        )
    }

    data class Saint(
        val bold: Int?,
        val churchTitle: String,
        val churchTitlePlural: String,
        val combinedGroup: Int?,
        val dateId: Int?,
        val enableChurchTitle: Int?,
        val enableTypeOfSanctity: Int?,
        val group: Int?,
        val hideIdeograph: Int?,
        val id: Int?,
        val ideograph: Int?,
        val imgs: List<Img?>?,
        val isCathedral: Int?,
        val linkToService: String,
        val name: String,
        val newmartyr: Int?,
        val number: Int?,
        val prefix: String,
        val priority: Int?,
        val saintsDatesStatsFltr: Int?,
        val sex: String,
        val splitGroup: Int?,
        val title: String,
        val typeOfSanctityComplete: String,
        val typeOfSanctityCompleteFemale: String,
        val typeOfSanctityPlural: String,
        val union: String,
        val uri: String,
        val url: String,
        val worldlyActivities: String,
        val generatedText: String
    ) {
        data class Img(
            val description: String,
            val id: Int?,
            val image: String,
            val onlyMain: Int?,
            val preview: String,
            val priority: Int?,
            val saintId: Int?,
            val title: String
        )
    }

    data class Text(
        val dateType: Int?,
        val refs: List<String?>?,
        val text: String,
        val type: Int?
    )
}