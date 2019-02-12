package com.cvdevelopers.checklist.utils.poweradapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem

class RecyclerViewHolder(view: ViewGroup, private val renderer: ItemRenderer<RecyclerItem>): RecyclerView.ViewHolder(renderer.createView(view)) {

    fun bind(item: RecyclerItem) =
        renderer.render(itemView, item)

}