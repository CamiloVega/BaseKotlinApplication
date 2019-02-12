package com.cvdevelopers.baseapplication.api.models

import com.google.gson.annotations.SerializedName

data class ModifierSchema (
    val id: Int,
    val type: String?,
    val name: String?,
    @SerializedName("additional_price")
    val additionalPrice: String?,
    @SerializedName("limit_selection_to")
    val limitSelectionTo: Int?,
    @SerializedName("require_selection")
    val requireSelection: Boolean = false,
    val options: List<ModifierOptionSchema>
)
