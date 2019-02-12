package com.cvdevelopers.baseapplication.api.models

import com.google.gson.annotations.SerializedName

data class TaxRateSchema (
    val rate: String,
    @SerializedName("receipt_label")
    val receiptLabel: String
)
