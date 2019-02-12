package com.cvdevelopers.baseapplication.fragments.cart.model

import com.cvdevelopers.baseapplication.fragments.cart.renderers.CartAdjutmentRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem

data class CartAdjustmentDisplayData(val id: Int, val name: String, val value: String): RecyclerItem {
    override fun getId(): Long =
        id.toLong()

    override fun getRendererKey(): String =
        CartAdjutmentRenderer.RENDER_KEY

    override fun getItemsHash(): Int =
            hashCode()

}
