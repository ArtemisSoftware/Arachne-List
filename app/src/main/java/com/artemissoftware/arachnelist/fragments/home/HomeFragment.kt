package com.artemissoftware.arachnelist.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentHomeBinding
import com.artemissoftware.arachnelist.databinding.FragmentMultipleBinding


class HomeFragment : Fragment(R.layout.fragment_home) {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentHomeBinding.bind(view)


        binding.btnSimpleRecycler.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_simpleFragment)

        }

        binding.btnListAdapter.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_listAdapterFragment)

        }

        binding.btnMultipleAdapter.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_multipleFragment)

        }
    }
}