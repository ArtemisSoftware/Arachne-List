package com.artemissoftware.arachnelist.fragments.listadapter.adapters

import androidx.recyclerview.widget.DiffUtil
import com.artemissoftware.arachnelist.models.Item

class ItemDiffCallback: DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.text1 == newItem.text1
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}