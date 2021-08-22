package com.artemissoftware.arachnelist.fragments.listadapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentListAdapterBinding
import com.artemissoftware.arachnelist.fragments.ItemViewModel
import com.artemissoftware.arachnelist.fragments.listadapter.adapters.ItemListAdapter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import android.os.Parcelable





class ListAdapterFragment : Fragment(R.layout.fragment_list_adapter) {

    private var _binding: FragmentListAdapterBinding? = null
    private val binding get() = _binding!!

    private val itemListAdapter by lazy { ItemListAdapter() }


    val itemViewModel: ItemViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentListAdapterBinding.bind(view)

        setupRecyclerView()

        binding.menuItemAdd.setOnClickListener {
            itemViewModel.addItem()
        }

        binding.menuItemRemove.setOnClickListener {
            itemViewModel.removeItem()
        }


        itemViewModel.addList((activity as MainActivity).generateDummyList(27))
        initCountObserver()
    }

    private fun setupRecyclerView() {

        binding.rclyListAdapter.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemListAdapter

        }
    }


    private fun initCountObserver() {
        lifecycleScope.launch {
            itemViewModel.listItem.collect { value ->

                itemListAdapter.submitList(value)
                binding.rclyListAdapter.getLayoutManager()?.onRestoreInstanceState((activity as MainActivity).recylerViewState);
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        val recylerViewState: Parcelable? = binding.rclyListAdapter.getLayoutManager()?.onSaveInstanceState()
        (activity as MainActivity).recylerViewState = recylerViewState
    }
}