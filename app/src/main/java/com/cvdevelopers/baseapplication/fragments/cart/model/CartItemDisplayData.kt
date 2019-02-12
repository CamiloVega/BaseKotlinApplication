package com.cvdevelopers.baseapplication.fragments.cart.model

import com.cvdevelopers.baseapplication.fragments.cart.renderers.CartItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem

class CartItemDisplayData(val id: Int, val quantity: String, val name: String, val price: String): RecyclerItem {
    override fun getId(): Long =
        id.toLong()

    override fun getRendererKey(): String =
        CartItemRenderer.RENDER_KEY

    override fun getItemsHash(): Int =
            hashCode()

}
