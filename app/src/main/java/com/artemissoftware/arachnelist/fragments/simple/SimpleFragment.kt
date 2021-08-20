package com.artemissoftware.arachnelist.fragments.simple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arachnelist.MainActivity
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentSimpleBinding
import com.artemissoftware.arachnelist.fragments.simple.adapters.SimpleAdapter


class SimpleFragment : Fragment(R.layout.fragment_simple) {


    private var _binding: FragmentSimpleBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentSimpleBinding.bind(view)

        setupRecyclerView()
    }


    private fun setupRecyclerView() {

        val exampleList = (activity as MainActivity).generateDummyList(4)
        val simpleAdapter = SimpleAdapter(exampleList)

        binding.rclySimple.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}