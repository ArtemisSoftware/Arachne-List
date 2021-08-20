package com.artemissoftware.arachnelist.fragments.binding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentListAdapterBinding
import com.artemissoftware.arachnelist.databinding.FragmentMultipleBinding
import com.artemissoftware.arachnelist.fragments.binding.adapter.ItemBindableListAdapter
import com.artemissoftware.arachnelist.fragments.listadapter.adapters.ItemListAdapter


class MultipleFragment : Fragment(R.layout.fragment_multiple) {

    private var _binding: FragmentMultipleBinding? = null
    private val binding get() = _binding!!

    private val itemListAdapter by lazy { ItemBindableListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentMultipleBinding.bind(view)

        setupRecyclerView()

        itemListAdapter.submitList((activity as MainActivity).generateDummyResourceList(2))

    }

    private fun setupRecyclerView() {

        binding.rclyMultipleAdapter.apply {
            adapter = itemListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}