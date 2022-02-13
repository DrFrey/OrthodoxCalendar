package com.example.orthodoxcalendar.domain.models

data class DateRuleLocal(
    val additionalText: List<AdditionalText?>?,
    val holidays: List<Holiday?>?,
    val icons: List<Icon?>?,
    val id: Int?,
    val saintsDatesStats: SaintsDatesStats?
) {
    data class AdditionalText(
        val id: Int?,
        val text: String?,
        val type: Int?
    )

    data class Holiday(
        val canonsOrAkathists: List<String?>?,
        val iconsOfHolidays: List<IconsOfHoliday?>?,
        val id: Int?,
        val ideograph: Int?,
        val priority: Int?,
        val title: String?,
        val tropariaOrKontakia: List<TropariaOrKontakia?>?,
        val uri: String?
    ) {
        data class IconsOfHoliday(
            val image: String?
        )

        data class TropariaOrKontakia(
            val id: Int?,
            val priority: Int?,
            val text: String?,
            val title: String?,
            val type: String?
        )
    }

    data class Icon(
        val cleanTitle: String?,
        val iconsOfOurLadyImgs: List<IconsOfOurLadyImg?>?,
        val id: Int?,
        val title: String?,
        val uri: String?
    ) {
        data class IconsOfOurLadyImg(
            val description: String?,
            val id: Int?,
            val img: String?,
            val priority: Int?
        )
    }

    data class SaintsDatesStats(
        val group: Int?,
        val ideograph: Int?,
        val number: Int?,
        val saints: List<Saint?>?
    ) {
        data class Saint(
            val description: String?,
            val iconsOfSaints: List<IconsOfSaint?>?,
            val id: Int?,
            val ideograph: Int?,
            val suffixGroup: String?,
            val title: String?,
            val titleGenitive: String?,
            val tropariaOrKontakia: List<TropariaOrKontakia?>?,
            val uri: String?
        ) {
            data class IconsOfSaint(
                val image: String?
            )

            data class TropariaOrKontakia(
                val id: Int?,
                val priority: Int?,
                val text: String?,
                val title: String?,
                val type: String?
            )
        }
    }
}
