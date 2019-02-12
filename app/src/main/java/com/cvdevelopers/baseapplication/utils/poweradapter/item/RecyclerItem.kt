package com.cvdevelopers.checklist.utils.poweradapter.item

interface RecyclerItem {
    fun getId(): Long
    fun getRendererKey(): String
    fun getItemsHash(): Int
}