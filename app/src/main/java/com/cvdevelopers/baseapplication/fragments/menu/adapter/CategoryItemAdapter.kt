package com.cvdevelopers.baseapplication.fragments.menu.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuItemDisplayData
import com.cvdevelopers.baseapplication.fragments.menu.viewholder.CategoryMenuItemViewHolder
import com.cvdevelopers.baseapplication.utils.inflate

class CategoryItemAdapter(val itemList: List<MenuItemDisplayData>): RecyclerView.Adapter<CategoryMenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMenuItemViewHolder {
        val view = parent.inflate(R.layout.category_menu_item)
        return CategoryMenuItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: CategoryMenuItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}