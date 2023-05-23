package com.arivera.parcialiipdm

import android.app.Application
import com.arivera.parcialiipdm.data.modelo.videogames
import com.arivera.parcialiipdm.repository.VideogameRepository

class VideogamesReviewerApplication(): Application() {
    val videogameRepository: VideogameRepository by lazy {
        VideogameRepository(videogames)
    }
}