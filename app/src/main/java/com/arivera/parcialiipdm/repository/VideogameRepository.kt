package com.arivera.parcialiipdm.repository

import com.arivera.parcialiipdm.data.modelo.VideogameModel

class VideogameRepository(private val videogameList: MutableList<VideogameModel>) {
    fun getVideogames() = videogameList

    fun addNewVideogame(videogame: VideogameModel) = videogameList.add(videogame)
}