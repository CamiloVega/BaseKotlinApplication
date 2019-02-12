package com.cvdevelopers.baseapplication.fragments.menu.model

import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuItemRenderer.Companion.RENDER_KEY
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem

data class CategoryDisplayData (val id: Int, val name: String, val items: List<MenuItemDisplayData>): RecyclerItem {
    override fun getId(): Long =
        id.toLong()

    override fun getRendererKey(): String =
        RENDER_KEY

     override fun getItemsHash(): Int =
         hashCode()
}