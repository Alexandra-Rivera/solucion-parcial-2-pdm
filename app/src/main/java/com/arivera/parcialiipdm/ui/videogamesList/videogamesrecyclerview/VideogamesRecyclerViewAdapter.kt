package com.arivera.parcialiipdm.ui.videogamesList.videogamesrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arivera.parcialiipdm.data.modelo.VideogameModel
import com.arivera.parcialiipdm.data.modelo.videogames
import com.arivera.parcialiipdm.databinding.NewvideogameitemBinding

class VideogamesRecyclerViewAdapter(private var clickListener: (VideogameModel) -> Unit): RecyclerView.Adapter<VideogamesRecyclerViewHolder>() {
    private val videogamesArray = ArrayList<VideogameModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideogamesRecyclerViewHolder {
        val binding = NewvideogameitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideogamesRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return videogamesArray.size
    }

    override fun onBindViewHolder(holder: VideogamesRecyclerViewHolder, position: Int) {
        val videogame = videogamesArray[position]
        holder.bind(videogame, clickListener)
    }

    fun setData(videogameList: List<VideogameModel>) {
        videogamesArray.clear()
        videogamesArray.addAll(videogameList.reversed())
    }
}