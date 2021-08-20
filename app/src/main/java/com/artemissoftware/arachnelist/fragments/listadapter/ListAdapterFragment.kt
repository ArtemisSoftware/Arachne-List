package com.artemissoftware.arachnelist.fragments.listadapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.artemissoftware.arachnelist.R
import com.artemissoftware.arachnelist.databinding.FragmentListAdapterBinding


class ListAdapterFragment : Fragment(R.layout.fragment_list_adapter) {

    private var _binding: FragmentListAdapterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentListAdapterBinding.bind(view)


    }

}