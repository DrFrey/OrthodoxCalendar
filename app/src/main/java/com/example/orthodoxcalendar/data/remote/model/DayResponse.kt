package com.example.orthodoxcalendar.data.remote.model


import com.example.orthodoxcalendar.data.utils.AlwaysListTypeAdapterFactory
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class DayResponse(
    @SerializedName("fasting")
    @JsonAdapter(AlwaysListTypeAdapterFactory::class)
    val fastings: List<Fasting?>?,

    @SerializedName("holidays")
    @JsonAdapter(AlwaysListTypeAdapterFactory::class)
    val holidays: List<Holiday?>?,

    @SerializedName("ikons")
    @JsonAdapter(AlwaysListTypeAdapterFactory::class)
    val ikons: List<Ikon?>?,

    @SerializedName("saints")
    @JsonAdapter(AlwaysListTypeAdapterFactory::class)
    val saints: List<Saint?>?,

    @SerializedName("texts")
    @JsonAdapter(AlwaysListTypeAdapterFactory::class)
    val texts: List<Text?>?
) {
    data class Fasting(
        @SerializedName("description")
        val description: String?,
        @SerializedName("fasting")
        val fasting: String?,
        @SerializedName("round_week")
        val roundWeek: String?,
        @SerializedName("separator")
        val separator: String?,
        @SerializedName("type")
        val type: Int?,
        @SerializedName("voice")
        val voice: Int?,
        @SerializedName("weeks")
        val weeks: String?
    )

    data class Holiday(
        @SerializedName("datepicker_class")
        val datepickerClass: String?,
        @SerializedName("days_after")
        val daysAfter: Int?,
        @SerializedName("days_before")
        val daysBefore: Int?,
        @SerializedName("favorite")
        val favorite: Int?,
        @SerializedName("full_title")
        val fullTitle: String?,
        @SerializedName("iconography")
        val iconography: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("ideograph")
        val ideograph: Int?,
        @SerializedName("imgs")
        val imgs: List<Img?>?,
        @SerializedName("liturgical_features")
        val liturgicalFeatures: String?,
        @SerializedName("marked")
        val marked: Int?,
        @SerializedName("meta_description")
        val metaDescription: String?,
        @SerializedName("pagetitle")
        val pagetitle: String?,
        @SerializedName("priority")
        val priority: Int?,
        @SerializedName("temples")
        val temples: String?,
        @SerializedName("theology")
        val theology: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("uri")
        val uri: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("url_base")
        val urlBase: Int?
    ) {
        data class Img(
            @SerializedName("description")
            val description: String?,
            @SerializedName("holiday_id")
            val holidayId: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("image")
            val image: String?,
            @SerializedName("priority")
            val priority: Int?,
            @SerializedName("preview")
            val preview: String?
        )
    }

    data class Ikon(
        @SerializedName("bold")
        val bold: Int?,
        @SerializedName("clean_title")
        val cleanTitle: String?,
        @SerializedName("date")
        val date: String?,
        @SerializedName("hide")
        val hide: Int?,
        @SerializedName("iconography")
        val iconography: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("ideograph")
        val ideograph: Int?,
        @SerializedName("imgs")
        val imgs: List<Img?>?,
        @SerializedName("liturgical_features")
        val liturgicalFeatures: String?,
        @SerializedName("meta_description")
        val metaDescription: String?,
        @SerializedName("number")
        val number: Int?,
        @SerializedName("_number")
        val _number: Int?,
        @SerializedName("temples")
        val temples: String?,
        @SerializedName("theology")
        val theology: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("uri")
        val uri: String?
    ) {
        data class Img(
            @SerializedName("description")
            val description: String?,
            @SerializedName("icon_of_our_lady_id")
            val iconOfOurLadyId: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("img")
            val img: String?,
            @SerializedName("priority")
            val priority: Int?
        )
    }

    data class Saint(
        @SerializedName("bold")
        val bold: Int?,
        @SerializedName("church_title")
        val churchTitle: String?,
        @SerializedName("church_title_genitive")
        val churchTitleGenitive: String?,
        @SerializedName("church_title_plural")
        val churchTitlePlural: String?,
        @SerializedName("combined_group")
        val combinedGroup: Int?,
        @SerializedName("date_id")
        val dateId: Int?,
        @SerializedName("enable_church_title")
        val enableChurchTitle: Int?,
        @SerializedName("enable_type_of_sanctity")
        val enableTypeOfSanctity: Int?,
        @SerializedName("group")
        val group: Int?,
        @SerializedName("hide_ideograph")
        val hideIdeograph: Int?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("ideograph")
        val ideograph: Int?,
        @SerializedName("imgs")
        val imgs: List<Img?>?,
        @SerializedName("is_cathedral")
        val isCathedral: Int?,
        @SerializedName("link_to_service")
        val linkToService: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("newmartyr")
        val newmartyr: Int?,
        @SerializedName("number")
        val number: Int?,
        @SerializedName("prefix")
        val prefix: String?,
        @SerializedName("priority")
        val priority: Int?,
        @SerializedName("saints_dates_stats_fltr")
        val saintsDatesStatsFltr: Int?,
        @SerializedName("sex")
        val sex: String?,
        @SerializedName("split_group")
        val splitGroup: Int?,
        @SerializedName("suffix")
        val suffix: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("title_genitive")
        val titleGenitive: String?,
        @SerializedName("type_of_sanctity")
        val typeOfSanctity: String?,
        @SerializedName("type_of_sanctity_complete")
        val typeOfSanctityComplete: String?,
        @SerializedName("type_of_sanctity_complete_female")
        val typeOfSanctityCompleteFemale: String?,
        @SerializedName("type_of_sanctity_plural")
        val typeOfSanctityPlural: String?,
        @SerializedName("union")
        val union: String?,
        @SerializedName("uri")
        val uri: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("worldly_activities")
        val worldlyActivities: String?
    ) {
        data class Img(
            @SerializedName("description")
            val description: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("image")
            val image: String?,
            @SerializedName("only_main")
            val onlyMain: Int?,
            @SerializedName("preview")
            val preview: String?,
            @SerializedName("priority")
            val priority: Int?,
            @SerializedName("saint_id")
            val saintId: Int?,
            @SerializedName("title")
            val title: String?
        )
    }

    data class Text(
        @SerializedName("date_type")
        val dateType: Int?,
        @SerializedName("refs")
        val refs: List<String?>?,
        @SerializedName("text")
        val text: String?,
        @SerializedName("type")
        val type: Int?
    )
}