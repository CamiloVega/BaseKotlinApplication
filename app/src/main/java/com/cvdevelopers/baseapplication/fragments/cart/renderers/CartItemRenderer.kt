package com.cvdevelopers.baseapplication.fragments.cart.renderers

import android.view.View
import android.view.ViewGroup
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.fragments.cart.model.CartItemDisplayData
import com.cvdevelopers.baseapplication.utils.inflate
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import kotlinx.android.synthetic.main.cart_line_item.view.*
import javax.inject.Inject

class CartItemRenderer @Inject constructor(): ItemRenderer<CartItemDisplayData> {

    override fun getLayoutId(): Int =
        R.layout.cart_line_item

    override fun createView(parent: ViewGroup): View =
        parent.inflate(getLayoutId(), false)

    override fun render(itemView: View, item: CartItemDisplayData) =
        bind(itemView, item)

    private fun bind(view: View, item: CartItemDisplayData) {
        view.name.text = item.name
        view.quantity.text = item.quantity
        view.price.text = item.price
    }

    companion object {
        const val RENDER_KEY = "CartItemRenderer"
    }
}