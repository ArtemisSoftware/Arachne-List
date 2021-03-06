package com.artemissoftware.arachnelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.artemissoftware.arachnelist.models.Item
import com.artemissoftware.arachnelist.models.ResourceView

class MainActivity : AppCompatActivity() {


    var recylerViewState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun generateDummyResourceList(size: Int): List<ResourceView.ItemValue> {

        val dummy: List<ResourceView.ItemValue> = generateDummyList(size).map { item -> ResourceView.ItemValue(item) }
        return dummy
    }


    fun generateDummyList(size: Int): ArrayList<Item> {
        val list = ArrayList<Item>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_scatter
                else -> R.drawable.ic_vertical_center
            }
            val item = Item(drawable, "Item $i", drawable.toString())
            list += item
        }
        return list
    }

}