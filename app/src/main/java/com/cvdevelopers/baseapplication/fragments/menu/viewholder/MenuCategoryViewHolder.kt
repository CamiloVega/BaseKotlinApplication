package com.cvdevelopers.baseapplication.fragments.menu.viewholder

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.baseapplication.fragments.menu.adapter.CategoryItemAdapter
import com.cvdevelopers.baseapplication.fragments.menu.model.CategoryDisplayData
import kotlinx.android.synthetic.main.menu_category_item.view.*


class MenuCategoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(category: CategoryDisplayData) {
        view.category_title.text = category.name
        view.menu_items_recyclerview.layoutManager = GridLayoutManager(view.context, 5)
        val adapter = CategoryItemAdapter(category.items)
        view.menu_items_recyclerview.adapter = adapter
    }
}