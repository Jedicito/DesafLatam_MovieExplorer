package chl.ancud.desaflatam_movieexplorer2.datos.remoto

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page:  Int = 1,
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int = 2
    ): MovieResponse

}