package com.artemissoftware.arachnelist.models

import com.artemissoftware.arachnelist.R

sealed class ResourceView(val resource: Int) {
    data class ItemValue(val item: Item) : ResourceView(R.layout.item_bindable)
}
