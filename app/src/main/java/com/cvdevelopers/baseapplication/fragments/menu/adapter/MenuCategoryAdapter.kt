package com.cvdevelopers.baseapplication.fragments.menu.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.fragments.menu.model.CategoryDisplayData
import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuCategoryViewHolder
import com.cvdevelopers.baseapplication.utils.inflate

class MenuCategoryAdapter: RecyclerView.Adapter<MenuCategoryViewHolder>() {

    var categoryList: List<CategoryDisplayData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryViewHolder {
        val view = parent.inflate(R.layout.menu_category_item)
        return MenuCategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: MenuCategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

}