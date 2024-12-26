package chl.ancud.desaflatam_movieexplorer2.presentacion.navegacion

import kotlinx.serialization.Serializable

@Serializable
object ListMovies

@Serializable
data class DetailsMovie(
    val movieId: Int
)
