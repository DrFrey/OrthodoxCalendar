package com.example.orthodoxcalendar.data.remote.model


import com.google.gson.annotations.SerializedName

class CacheDateResponse : ArrayList<CacheDateResponse.CacheDateResponseItem>(){
    data class CacheDateResponseItem(
        @SerializedName("dateRule") val dateRule: DateRule?
    ) {
        data class DateRule(
            @SerializedName("additionalText") val additionalText: List<AdditionalText?>?,
            @SerializedName("holidays") val holidays: List<Holiday?>?,
            @SerializedName("icons") val icons: List<Icon?>?,
            @SerializedName("id") val id: Int?,
            @SerializedName("saintsDatesStats") val saintsDatesStats: SaintsDatesStats?
        ) {
            data class AdditionalText(
                @SerializedName("id") val id: Int?,
                @SerializedName("text") val text: String?,
                @SerializedName("type") val type: Int?
            )
    
            data class Holiday(
                @SerializedName("canonsOrAkathists") val canonsOrAkathists: List<String?>?,
                @SerializedName("iconsOfHolidays") val iconsOfHolidays: List<IconsOfHoliday?>?,
                @SerializedName("id") val id: Int?,
                @SerializedName("ideograph") val ideograph: Int?,
                @SerializedName("priority") val priority: Int?,
                @SerializedName("title") val title: String?,
                @SerializedName("tropariaOrKontakia") val tropariaOrKontakia: List<TropariaOrKontakia?>?,
                @SerializedName("uri") val uri: String?
            ) {
                data class IconsOfHoliday(
                    @SerializedName("image") val image: String?
                )
    
                data class TropariaOrKontakia(
                    @SerializedName("id") val id: Int?,
                    @SerializedName("priority") val priority: Int?,
                    @SerializedName("text") val text: String?,
                    @SerializedName("title") val title: String?,
                    @SerializedName("type") val type: String?
                )
            }
    
            data class Icon(
                @SerializedName("cleanTitle") val cleanTitle: String?,
                @SerializedName("iconsOfOurLadyImgs") val iconsOfOurLadyImgs: List<IconsOfOurLadyImg?>?,
                @SerializedName("id") val id: Int?,
                @SerializedName("title") val title: String?,
                @SerializedName("uri") val uri: String?
            ) {
                data class IconsOfOurLadyImg(
                    @SerializedName("description") val description: String?,
                    @SerializedName("id") val id: Int?,
                    @SerializedName("img") val img: String?,
                    @SerializedName("priority") val priority: Int?
                )
            }
    
            data class SaintsDatesStats(
                @SerializedName("group") val group: Int?,
                @SerializedName("ideograph") val ideograph: Int?,
                @SerializedName("number") val number: Int?,
                @SerializedName("saints") val saints: List<Saint?>?
            ) {
                data class Saint(
                    @SerializedName("description") val description: String?,
                    @SerializedName("iconsOfSaints") val iconsOfSaints: List<IconsOfSaint?>?,
                    @SerializedName("id") val id: Int?,
                    @SerializedName("ideograph") val ideograph: Int?,
                    @SerializedName("suffixGroup") val suffixGroup: String?,
                    @SerializedName("title") val title: String?,
                    @SerializedName("titleGenitive") val titleGenitive: String?,
                    @SerializedName("tropariaOrKontakia") val tropariaOrKontakia: List<TropariaOrKontakia?>?,
                    @SerializedName("uri") val uri: String?
                ) {
                    data class IconsOfSaint(
                        @SerializedName("image") val image: String?
                    )
    
                    data class TropariaOrKontakia(
                        @SerializedName("id") val id: Int?,
                        @SerializedName("priority") val priority: Int?,
                        @SerializedName("text") val text: String?,
                        @SerializedName("title") val title: String?,
                        @SerializedName("type") val type: String?
                    )
                }
            }
        }
    }
}