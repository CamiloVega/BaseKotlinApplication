package com.cvdevelopers.baseapplication.fragments.menu.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuItemDisplayData
import kotlinx.android.synthetic.main.category_menu_item.view.*

class CategoryMenuItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(item: MenuItemDisplayData) {
        view.name.text = item.name
        view.price.text = item.price
        item.color?.let {
            view.color_bar.setBackgroundColor(view.resources.getColor(it))
        }
        view.setOnClickListener {
            item.onClickListener(item)
        }
    }
}