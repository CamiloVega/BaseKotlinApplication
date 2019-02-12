package com.cvdevelopers.baseapplication.api.models

import com.google.gson.annotations.SerializedName

data class MenuMetaSchema (
    @SerializedName("incorporated_menu_ids")
    val incorporatedMenuIds: List<Int>,
    @SerializedName("menu_version_timestamp")
    val menuVersionTimeStamp: String
)
