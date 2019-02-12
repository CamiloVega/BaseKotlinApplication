package com.cvdevelopers.checklist.utils.poweradapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val dataSource: RecyclerDataSource): RecyclerView.Adapter<RecyclerViewHolder>() {

    init {
        dataSource.attachAdapter(this)
        setHasStableIds(true)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(parent, dataSource.rendererForViewType(viewType))

    override fun getItemCount(): Int =
        dataSource.getCount()

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) =
        holder.bind(dataSource.getItem(position))

    override fun getItemId(position: Int): Long =
        dataSource.getItem(position).getId()

    override fun getItemViewType(position: Int): Int =
            dataSource.getLayoutResourceForPosition(position) ?: -1

}