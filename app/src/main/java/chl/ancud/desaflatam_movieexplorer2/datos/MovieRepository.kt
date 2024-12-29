package chl.ancud.desaflatam_movieexplorer2.datos

import chl.ancud.desaflatam_movieexplorer2.datos.remoto.MovieApi
import chl.ancud.desaflatam_movieexplorer2.modelos.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class MovieRepository @Inject constructor(
    private val api: MovieApi
) {

    open suspend fun getPopularMovies(page: Int) : Result<List<Movie>> {
        return try {
            val response = api.getPopularMovies(
                page = page,
            )
            Result.success(response.movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getDetailsMovie(movieId: Int) : Result<List<Movie>> {
        return try {
            val response = api.getDetailsMovie(
                movieId = movieId,
            )
            Result.success(response.movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}