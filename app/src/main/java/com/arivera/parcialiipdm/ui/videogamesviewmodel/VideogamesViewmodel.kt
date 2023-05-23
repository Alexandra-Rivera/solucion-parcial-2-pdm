package com.arivera.parcialiipdm.ui.videogamesviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arivera.parcialiipdm.VideogamesReviewerApplication
import com.arivera.parcialiipdm.data.modelo.VideogameModel
import com.arivera.parcialiipdm.repository.VideogameRepository

class VideogamesViewmodel(private val videogamesRepository: VideogameRepository): ViewModel() {
    val name = MutableLiveData("")
    val genre = MutableLiveData("")
    val status = MutableLiveData("")

    fun createNewVideogame() {
        if (!dataValidation()) {
            clearData()
            status.value = WRONG_INFORMATION
        }

        val newVideogame = VideogameModel(name.value!!, genre.value!!)
        videogamesRepository.addNewVideogame(newVideogame)

        clearData()
        status.value = CREATED
    }

    private fun dataValidation(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            genre.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        genre.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun getVideogames() = videogamesRepository.getVideogames()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as VideogamesReviewerApplication
                VideogamesViewmodel(app.videogameRepository)
            }
        }
        const val CREATED = "New videogame created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE  = "Inactive"
    }

    fun setSelectedItemData(videogame: VideogameModel) {
        name.value = videogame.name
        genre.value = videogame.genre
    }
}