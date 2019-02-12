package com.cvdevelopers.checklist.utils.poweradapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem

class RecyclerDiffCallback(val oldItems: List<out RecyclerItem>, val newItems: List<out RecyclerItem>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].getId() == newItems[newItemPosition].getId()

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].getItemsHash() == newItems[newItemPosition].getItemsHash()
}