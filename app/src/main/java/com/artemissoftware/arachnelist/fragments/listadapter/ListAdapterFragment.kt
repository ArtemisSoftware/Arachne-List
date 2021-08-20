package com.artemissoftware.arachnelist.fragments.listadapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentListAdapterBinding
import com.artemissoftware.arachnelist.fragments.listadapter.adapters.ItemListAdapter


class ListAdapterFragment : Fragment(R.layout.fragment_list_adapter) {

    private var _binding: FragmentListAdapterBinding? = null
    private val binding get() = _binding!!

    private val itemListAdapter by lazy { ItemListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentListAdapterBinding.bind(view)

        setupRecyclerView()

        itemListAdapter.submitList((activity as MainActivity).generateDummyList(7))

    }

    private fun setupRecyclerView() {

        binding.rclyListAdapter.apply {
            adapter = itemListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}