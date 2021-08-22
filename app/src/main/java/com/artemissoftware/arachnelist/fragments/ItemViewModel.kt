package com.artemissoftware.arachnelist.fragments

import androidx.lifecycle.ViewModel
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.models.Item
import com.artemissoftware.arachnelist.models.ResourceView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class ItemViewModel : ViewModel(){


    private val _listItem= MutableStateFlow(listOf<Item>())
    val listItem: StateFlow<List<Item>> = _listItem

    fun addList(dummyList: ArrayList<Item>) {
        _listItem.value = dummyList
    }


    fun addItem() {

        var itemList = _listItem.value.toMutableList()

        var index = 0

        if(itemList.size != 0){
            index = Random.nextInt(itemList.size)
        }

        val newItem = Item(R.drawable.ic_new, "New item at position $index", (R.drawable.ic_new).toString())
        itemList.add(index, newItem)

        _listItem.value = itemList

    }


    fun removeItem() {

        var itemList = _listItem.value.toMutableList()

        if(itemList.size == 0){
            return
        }

        val index = Random.nextInt(itemList.size)
        itemList.removeAt(index)

        _listItem.value = itemList

    }





    private val _multipleListItem= MutableStateFlow(listOf<ResourceView.ItemValue>())
    val multipleListItem: StateFlow<List<ResourceView.ItemValue>> = _multipleListItem


    fun addMultipleList(dummyList: List<ResourceView.ItemValue>) {
        _multipleListItem.value = dummyList
    }


}