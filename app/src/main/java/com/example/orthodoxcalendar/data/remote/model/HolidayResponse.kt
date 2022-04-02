package com.example.orthodoxcalendar.data.remote.model


import com.google.gson.annotations.SerializedName

data class HolidayResponse(
    @SerializedName("canonsOrAkathists") val canonsOrAkathists: List<String>?,
    @SerializedName("daysAfter") val daysAfter: Int?,
    @SerializedName("daysBefore") val daysBefore: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("favorite") val favorite: Boolean?,
    @SerializedName("iconsOfHolidays") val iconsOfHolidays: List<IconsOfHoliday>?,
    @SerializedName("id") val id: Int,
    @SerializedName("ideograph") val ideograph: Int?,
    @SerializedName("liturgicalFeatures") val liturgicalFeatures: String?,
    @SerializedName("marked") val marked: Boolean?,
    @SerializedName("pagetitle") val pagetitle: String?,
    @SerializedName("priority") val priority: Int?,
    @SerializedName("temples") val temples: String?,
    @SerializedName("theology") val theology: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("tropariaOrKontakia") val tropariaOrKontakia: List<TropariaOrKontakiaResponse>?,
    @SerializedName("uri") val uri: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("urlBase") val urlBase: Int?
) {
    data class IconsOfHoliday(
        @SerializedName("image") val image: String?
    )
}