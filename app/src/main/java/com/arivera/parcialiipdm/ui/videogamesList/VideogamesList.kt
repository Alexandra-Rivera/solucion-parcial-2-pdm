package com.arivera.parcialiipdm.ui.videogamesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arivera.parcialiipdm.R
import com.arivera.parcialiipdm.data.modelo.VideogameModel
import com.arivera.parcialiipdm.data.modelo.videogames
import com.arivera.parcialiipdm.databinding.FragmentVideogamesListBinding
import com.arivera.parcialiipdm.ui.videogamesList.videogamesrecyclerview.VideogamesRecyclerViewAdapter
import com.arivera.parcialiipdm.ui.videogamesviewmodel.VideogamesViewmodel

class VideogamesList : Fragment() {

    private val videogameViewModel: VideogamesViewmodel by activityViewModels {
        VideogamesViewmodel.Factory
    }
    private lateinit var adapter: VideogamesRecyclerViewAdapter
    private lateinit var binding: FragmentVideogamesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideogamesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewVideogamefabButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_videogamesList_to_newVideogames)
        }
    }

    fun showSelectedItem(videogame: VideogameModel) {
        videogameViewModel.setSelectedItemData(videogame)
    }

    fun displayVideogames() {
        adapter.setData(videogameViewModel.getVideogames())
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerview() {
        binding.videogamesRecyclerview.layoutManager = LinearLayoutManager(context)
        adapter = VideogamesRecyclerViewAdapter {selectedVideogame ->
            showSelectedItem(selectedVideogame)
        }

        binding.videogamesRecyclerview.adapter = adapter
        displayVideogames()
    }
}