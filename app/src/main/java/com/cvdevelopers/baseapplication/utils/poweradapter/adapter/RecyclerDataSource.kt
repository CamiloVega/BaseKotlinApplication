package com.cvdevelopers.checklist.utils.poweradapter.adapter

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem
import java.lang.ref.WeakReference

class RecyclerDataSource constructor(val renderers: Map<String, ItemRenderer<out RecyclerItem>>) {

    private var data = ArrayList<RecyclerItem>()
    var viewTypeToRendererKey: HashMap<Int, String> = HashMap()
    var adapter: WeakReference<RecyclerView.Adapter<out RecyclerView.ViewHolder>>? = null
    init {
        renderers.forEach {
            viewTypeToRendererKey[it.value.getLayoutId()] = it.key
        }
    }

    @Suppress("unused")
    fun setData(newData: List<RecyclerItem>) {
        val diffCallback = DiffUtil.calculateDiff(RecyclerDiffCallback(data, newData))
        data.clear()
        data.addAll(newData)
        adapter?.get()?.let { diffCallback.dispatchUpdatesTo(it) }

    }

    fun rendererForViewType(viewType: Int): ItemRenderer<RecyclerItem> =
        renderers[viewTypeToRendererKey[viewType]] as ItemRenderer<RecyclerItem>

    @LayoutRes
    fun getLayoutResourceForPosition(position: Int):Int? =
        renderers[data[position].getRendererKey()]?.getLayoutId()

    fun getCount(): Int = data.size

    fun getItem(position: Int): RecyclerItem = data[position]

    fun attachAdapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
        this.adapter = WeakReference(adapter)
    }
}