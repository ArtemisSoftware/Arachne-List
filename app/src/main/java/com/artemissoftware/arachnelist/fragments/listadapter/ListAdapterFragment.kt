package com.artemissoftware.arachnelist.fragments.listadapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentListAdapterBinding
import com.artemissoftware.arachnelist.fragments.ItemViewModel
import com.artemissoftware.arachnelist.fragments.listadapter.adapters.ItemListAdapter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


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

        initCountObserver()
        itemViewModel.addList((activity as MainActivity).generateDummyList(7))
    }

    private fun setupRecyclerView() {

        binding.rclyListAdapter.apply {
            adapter = itemListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    private fun initCountObserver() {
        lifecycleScope.launch {
            itemViewModel.listItem.collect { value ->

                itemListAdapter.submitList(value)

            }
        }
    }
}