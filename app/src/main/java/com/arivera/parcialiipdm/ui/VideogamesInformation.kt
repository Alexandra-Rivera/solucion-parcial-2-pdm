package com.arivera.parcialiipdm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.arivera.parcialiipdm.databinding.FragmentVideogamesInformationBinding
import com.arivera.parcialiipdm.ui.videogamesviewmodel.VideogamesViewmodel

class VideogamesInformation : Fragment() {

    private val videogamesViewmodel: VideogamesViewmodel by activityViewModels {
        VideogamesViewmodel.Factory
    }
    private lateinit var binding: FragmentVideogamesInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.viewmodel = videogamesViewmodel
        binding = FragmentVideogamesInformationBinding.inflate(inflater, container, false)
        return binding.root
    }
}