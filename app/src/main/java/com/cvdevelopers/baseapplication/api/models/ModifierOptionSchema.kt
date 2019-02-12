package com.cvdevelopers.baseapplication.api.models

import com.google.gson.annotations.SerializedName

data class ModifierOptionSchema (
    val id: Int,
    val name: String?,
    val price: String?,
    val quantity: String?,
    @SerializedName("unit_of_measurement")
    val unitOfMeasurement: String?
)
