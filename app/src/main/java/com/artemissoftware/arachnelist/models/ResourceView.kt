package com.artemissoftware.arachnelist.models

import com.artemissoftware.arachnelist.R

sealed class ResourceView(val id: String, val resource: Int) {
    data class ItemValue(val item: Item) : ResourceView(item.text1, R.layout.item_bindable)
}
