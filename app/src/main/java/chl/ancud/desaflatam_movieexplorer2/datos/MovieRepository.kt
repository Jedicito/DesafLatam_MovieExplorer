package chl.ancud.desaflatam_movieexplorer2.datos

import chl.ancud.desaflatam_movieexplorer2.datos.local.MoviesDao
import chl.ancud.desaflatam_movieexplorer2.datos.remoto.MovieApi
import chl.ancud.desaflatam_movieexplorer2.modelos.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class MovieRepository @Inject constructor(
    private val moviesApi: MovieApi,
    private val moviesDao: MoviesDao
) {

    suspend fun getPopularMoviesApi(page: Int) : Result<List<Movie>> {
        return try {
            val response = moviesApi.getPopularMovies(
                page = page,
            )
            Result.success(response.movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getFavoritesMoviesRoom() : Result<List<Movie>> {
        return try {
            val response = moviesDao.getFavoritesMovies()
            Result.success(response.map { it.toMovie() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getDetailsMovieApi(movieId: Int) : Result<List<Movie>> {
        return try {
            val response = moviesApi.getDetailsMovie(
                movieId = movieId,
            )
            Result.success(response.movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}