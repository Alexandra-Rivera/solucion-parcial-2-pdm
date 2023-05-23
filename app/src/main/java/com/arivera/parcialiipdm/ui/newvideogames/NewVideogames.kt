package com.arivera.parcialiipdm.ui.newvideogames

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arivera.parcialiipdm.R
import com.arivera.parcialiipdm.databinding.FragmentNewVideogamesBinding
import com.arivera.parcialiipdm.ui.videogamesviewmodel.VideogamesViewmodel

class NewVideogames : Fragment() {

    private val videogamesViewmodel: VideogamesViewmodel by activityViewModels {
        VideogamesViewmodel.Factory
    }
    private lateinit var binding: FragmentNewVideogamesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewVideogamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewmodel()
        statusObserver()
    }

    fun setViewmodel() {
        binding.viewmodel = videogamesViewmodel
    }

    private fun statusObserver() {
        videogamesViewmodel.status.observe(viewLifecycleOwner){ status ->
            when {
                status.equals(VideogamesViewmodel.CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, videogamesViewmodel.getVideogames().toString())

                    videogamesViewmodel.clearStatus()
                    findNavController().popBackStack()
                }

                status.equals(VideogamesViewmodel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    videogamesViewmodel.clearStatus()
                }
            }
        }
    }

    companion object{
        const val APP_TAG = "APP_TAG"
    }
}