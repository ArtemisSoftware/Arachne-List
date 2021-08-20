package com.artemissoftware.arachnelist.fragments.binding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.ItemBindableBinding
import com.artemissoftware.arachnelist.models.ResourceView

class ItemBindableListAdapter() : ListAdapter<ResourceView, DataViewHolder>(ItemBindableDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        return when(viewType){
            R.layout.item_bindable -> DataViewHolder.ItemViewHolder(ItemBindableBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//            R.layout.item_movie -> HomeRecyclerViewHolder.MovieViewHolder(
//                ItemMovieBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//            R.layout.item_director -> HomeRecyclerViewHolder.DirectorViewHolder(
//                ItemDirectorBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        when(holder){
            is DataViewHolder.ItemViewHolder -> holder.bind(getItem(position))
//            is HomeRecyclerViewHolder.MovieViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Movie)
//            is HomeRecyclerViewHolder.TitleViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Title)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return getItem(position).resource
    }




//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
//        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
//        return ItemHolder(view)
//    }
//
//
//    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//
//    override fun getItemViewType(position: Int): Int {
//        return getItem(position).resource
//    }
//
//    inner class ItemHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(view) {
//
//        fun bind(item: ResourceView) {
//
//
//
//            when(item) {
//                is ResourceView.ItemValue -> {
//                    (binding is ItemBindableBinding).setI = item.title
//                    detailTextView.text = "${item.childCount} items"
//                }
//            }
//
//
//
//
//
//            view.image_view.setImageResource(item.imageResource)
//            view.text_view_1.text = item.text1
//            view.text_view_2.text = item.text2
//
//
////            view.setOnClickListener {
////                listener.onClick(view)
////            }
//        }
//    }

}