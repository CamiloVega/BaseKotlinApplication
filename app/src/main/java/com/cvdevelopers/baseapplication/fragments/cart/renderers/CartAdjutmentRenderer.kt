package com.cvdevelopers.baseapplication.fragments.cart.renderers

import android.view.View
import android.view.ViewGroup
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.fragments.cart.model.CartAdjustmentDisplayData
import com.cvdevelopers.baseapplication.utils.inflate
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import kotlinx.android.synthetic.main.cart_adjustment_item.view.*

import javax.inject.Inject

class CartAdjutmentRenderer @Inject constructor(): ItemRenderer<CartAdjustmentDisplayData> {

    override fun getLayoutId(): Int =
        R.layout.cart_adjustment_item

    override fun createView(parent: ViewGroup): View =
        parent.inflate(getLayoutId(), false)

    override fun render(itemView: View, item: CartAdjustmentDisplayData) =
        bind(itemView, item)

    private fun bind(view: View, item: CartAdjustmentDisplayData) {
        view.name.text = item.name
        view.value.text = item.value
    }

    companion object {
        const val RENDER_KEY = "CartAdjustmentRenderer"
    }
}