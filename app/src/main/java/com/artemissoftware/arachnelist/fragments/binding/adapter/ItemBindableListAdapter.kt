package com.artemissoftware.arachnelist.fragments.binding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.fragments.listadapter.adapters.ItemDiffCallback
import com.artemissoftware.arachnelist.models.Item
import kotlinx.android.synthetic.main.item_simple.view.*

class ItemBindableListAdapter() : ListAdapter<Item, ItemBindableListAdapter.ItemHolder>(ItemDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ItemHolder(view)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }


//    override fun getItemViewType(position: Int): Int {
//        return getItem(position).resource
//    }

    inner class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {

            view.image_view.setImageResource(item.imageResource)
            view.text_view_1.text = item.text1
            view.text_view_2.text = item.text2


//            view.setOnClickListener {
//                listener.onClick(view)
//            }
        }
    }

}