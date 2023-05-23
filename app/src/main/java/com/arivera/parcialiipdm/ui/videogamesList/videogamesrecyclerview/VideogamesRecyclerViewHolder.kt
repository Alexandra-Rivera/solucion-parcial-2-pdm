package com.arivera.parcialiipdm.ui.videogamesList.videogamesrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.arivera.parcialiipdm.data.modelo.VideogameModel
import com.arivera.parcialiipdm.databinding.NewvideogameitemBinding

class VideogamesRecyclerViewHolder(private var binding: NewvideogameitemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(videogame: VideogameModel, clickListener: (VideogameModel) -> Unit) {
        binding.videogameName.text = videogame.name
        binding.videogameGenre.text = videogame.genre

        binding.videogameItemCardview.setOnClickListener{
            clickListener(videogame)
        }
    }
}