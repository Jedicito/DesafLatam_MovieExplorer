package chl.ancud.desaflatam_movieexplorer2.datos

import chl.ancud.desaflatam_movieexplorer2.datos.remoto.RetrofitClient
import chl.ancud.desaflatam_movieexplorer2.modelos.Movie


class MovieRepository {
    private val api = RetrofitClient.movieApi

    suspend fun getPopularMovies(page: Int) : Result<List<Movie>> {
        return try {
            val response = api.searchMovies(
                page = page,
                query = "The godfather"
            )
            Result.success(response.movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}