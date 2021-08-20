package com.artemissoftware.arachnelist.fragments.binding.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.artemissoftware.arachnelist.databinding.ItemBindableBinding
import com.artemissoftware.arachnelist.models.Item
import com.artemissoftware.arachnelist.models.ResourceView

sealed class DataViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class ItemViewHolder(private val binding: ItemBindableBinding) : DataViewHolder(binding){
        fun bind(resourceView: ResourceView){

            binding.item = (resourceView as ResourceView.ItemValue).item
            binding.imageView.setImageResource(resourceView.item.imageResource)
        }
    }

//    class MovieViewHolder(private val binding: ItemMovieBinding) : HomeRecyclerViewHolder(binding){
//        fun bind(movie: HomeRecyclerViewItem.Movie){
//            binding.imageViewMovie.loadImage(movie.thumbnail)
//        }
//    }
//
//    class DirectorViewHolder(private val binding: ItemDirectorBinding) : HomeRecyclerViewHolder(binding){
//        fun bind(director: HomeRecyclerViewItem.Director){
//            binding.imageViewDirector.loadImage(director.avatar)
//            binding.textViewName.text = director.name
//            binding.textViewMovies.text = binding.textViewMovies.context.getString(R.string.total_movies, director.movie_count)
//        }
//    }
}
