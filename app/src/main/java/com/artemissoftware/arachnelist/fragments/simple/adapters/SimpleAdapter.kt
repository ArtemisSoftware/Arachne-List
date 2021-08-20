package com.artemissoftware.arachnelist.fragments.simple.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.models.Item
import kotlinx.android.synthetic.main.item_simple.view.*
import kotlin.random.Random

class SimpleAdapter (private val itemList: MutableList<Item>/*, private val listener: OnItemClickListener*/) : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        return SimpleViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {

        val currentItem = itemList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

    }


    override fun getItemCount(): Int {
        return itemList.size
    }



    fun insertItem(){

        val index = Random.nextInt(8)
        val newItem = Item(R.drawable.ic_android, "New item at position $index", (R.drawable.ic_android).toString())
        itemList.add(index, newItem)
        notifyItemInserted(index)
    }

    fun removeItem(){
        val index = Random.nextInt(8)
        itemList.removeAt(index)
        notifyItemRemoved(index)
    }





    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val imageView : ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                //--listener.onItemClick(position)
            }
        }
    }

//    interface OnItemClickListener{
//        fun onItemClick(position : Int)
//    }

}