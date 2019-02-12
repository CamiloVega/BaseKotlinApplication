package com.cvdevelopers.baseapplication.api.models

data class MenuSchema (
    val categories: List<CategorySchema>,
    val meta: MenuMetaSchema
)