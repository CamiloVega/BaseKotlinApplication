package com.cvdevelopers.baseapplication.api.models

data class CategorySchema (
    val id: Int,
    val name: String,
    val limit: Int?,
    val alcohol: Boolean = false,
    val position: Int? = 0,
    val description: String?,
    val items: List<ItemSchema> = emptyList()
)