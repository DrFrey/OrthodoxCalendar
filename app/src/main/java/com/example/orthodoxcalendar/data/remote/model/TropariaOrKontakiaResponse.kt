package com.example.orthodoxcalendar.data.remote.model

import com.google.gson.annotations.SerializedName

data class TropariaOrKontakiaResponse(
    @SerializedName("audioSource") val audioSource: String?,
    @SerializedName("duration") val duration: Int?,
    @SerializedName("id") val id: Int,
    @SerializedName("priority") val priority: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("voice") val voice: String?
)