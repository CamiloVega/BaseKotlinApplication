package com.cvdevelopers.baseapplication.fragments.menu.model

data class MenuItemDisplayData (
    val name: String,
    val price: String,
    val color: Int?,
    val onClickListener: (MenuItemDisplayData) -> Unit
)