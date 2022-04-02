package com.example.orthodoxcalendar.data.remote.model


import com.google.gson.annotations.SerializedName

data class SaintResponse(
    @SerializedName("description") val description: String?,
    @SerializedName("enableChurchTitleGroup") val enableChurchTitleGroup: Boolean?,
    @SerializedName("enableTypeOfSanctityGroup") val enableTypeOfSanctityGroup: Boolean?,
    @SerializedName("group") val group: Int?,
    @SerializedName("iconsOfSaints") val iconsOfSaints: List<IconsOfSaint>?,
    @SerializedName("id") val id: Int,
    @SerializedName("ideograph") val ideograph: Int?,
    @SerializedName("isCathedral") val isCathedral: Boolean?,
    @SerializedName("isMenologyRpc") val isMenologyRpc: Boolean?,
    @SerializedName("linkToService") val linkToService: String?,
    @SerializedName("newmartyr") val newmartyr: Boolean?,
    @SerializedName("number") val number: Int?,
    @SerializedName("prefixGroup") val prefixGroup: String?,
    @SerializedName("priority") val priority: Boolean?,
    @SerializedName("skipInMenology") val skipInMenology: Boolean?,
    @SerializedName("suffixGroup") val suffixGroup: String?,
    @SerializedName("temples") val temples: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("titleGenitive") val titleGenitive: String?,
    @SerializedName("titleGroup") val titleGroup: String?,
    @SerializedName("tropariaOrKontakia") val tropariaOrKontakia: List<TropariaOrKontakiaResponse>?,
    @SerializedName("unionGroup") val unionGroup: String?,
    @SerializedName("uri") val uri: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("worldlyActivities") val worldlyActivities: String?
) {
    data class IconsOfSaint(
        @SerializedName("image") val image: String?
    )
}