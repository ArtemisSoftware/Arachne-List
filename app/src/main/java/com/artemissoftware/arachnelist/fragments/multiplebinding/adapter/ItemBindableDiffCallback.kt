package com.artemissoftware.arachnelist.fragments.multiplebinding.adapter

import androidx.recyclerview.widget.DiffUtil
import com.artemissoftware.arachnelist.models.ResourceView

class ItemBindableDiffCallback : DiffUtil.ItemCallback<ResourceView>() {

    override fun areItemsTheSame(oldItem: ResourceView, newItem: ResourceView): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResourceView, newItem: ResourceView): Boolean {
        return oldItem == newItem
    }
}