package com.artemissoftware.arachnelist.fragments

import androidx.lifecycle.ViewModel
import com.artemissoftware.arachnelist.models.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel : ViewModel(){


    private val _listItem= MutableStateFlow(mutableListOf<Item>())
    val listItem: StateFlow<List<Item>> = _listItem

    fun addList(dummyList: ArrayList<Item>) {
        _listItem.value = dummyList
    }

}