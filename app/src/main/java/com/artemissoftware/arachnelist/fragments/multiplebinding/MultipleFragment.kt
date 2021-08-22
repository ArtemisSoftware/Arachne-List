package com.artemissoftware.arachnelist.fragments.multiplebinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentMultipleBinding
import com.artemissoftware.arachnelist.fragments.ItemViewModel
import com.artemissoftware.arachnelist.fragments.multiplebinding.adapter.ItemBindableListAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MultipleFragment : Fragment(R.layout.fragment_multiple) {

    private var _binding: FragmentMultipleBinding? = null
    private val binding get() = _binding!!

    private val itemListAdapter by lazy { ItemBindableListAdapter() }

    val itemViewModel: ItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentMultipleBinding.bind(view)

        setupRecyclerView()

        itemViewModel.addMultipleList((activity as MainActivity).generateDummyResourceList(2))

        initCountObserver()
    }

    private fun setupRecyclerView() {

        binding.rclyMultipleAdapter.apply {
            adapter = itemListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initCountObserver() {
        lifecycleScope.launch {
            itemViewModel.multipleListItem.collect { value ->

                itemListAdapter.submitList(value)

            }
        }
    }
}