package com.cvdevelopers.baseapplication.fragments.menu.viewholder

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.fragments.menu.adapter.CategoryItemAdapter
import com.cvdevelopers.baseapplication.fragments.menu.model.CategoryDisplayData
import com.cvdevelopers.baseapplication.utils.inflate
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import kotlinx.android.synthetic.main.menu_category_item.view.*
import javax.inject.Inject

class MenuItemRenderer @Inject constructor(): ItemRenderer<CategoryDisplayData> {

    override fun getLayoutId(): Int =
        R.layout.menu_category_item

    override fun createView(parent: ViewGroup): View =
        parent.inflate(getLayoutId(), false)

    override fun render(itemView: View, item: CategoryDisplayData) =
        bind(itemView, item)

    private fun bind(view: View, category: CategoryDisplayData) {
        view.category_title.text = category.name
        view.menu_items_recyclerview.layoutManager = GridLayoutManager(view.context, 5)
        val adapter = CategoryItemAdapter(category.items)
        view.menu_items_recyclerview.adapter = adapter
    }

    companion object {
        const val RENDER_KEY = "MenuItemRenderer"
    }
}