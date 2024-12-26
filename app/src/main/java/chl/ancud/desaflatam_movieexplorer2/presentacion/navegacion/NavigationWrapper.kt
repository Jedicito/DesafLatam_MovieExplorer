package chl.ancud.desaflatam_movieexplorer2.presentacion.navegacion

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import chl.ancud.desaflatam_movieexplorer2.modelos.MovieViewModel
import chl.ancud.desaflatam_movieexplorer2.presentacion.MovieDetailScreen
import chl.ancud.desaflatam_movieexplorer2.presentacion.MovieScreen

/*
Navegación en Jetpack Compose
https://www.youtube.com/watch?v=1OxiEaEWEe4
*/

@Composable
fun NavigationWrapper(viewModel: MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListMovies) {
        composable<ListMovies> {
            MovieScreen(
                viewModel = viewModel,
                navController = navController
            )
        }


        composable<DetailsMovie> {
            // Extraer el movieId de los argumentos
            //val movieId = it.arguments?.getString("movieId")?.toIntOrNull()
            val detail = it.toRoute<DetailsMovie>()
            //Log.d("NavigationWrapper", "composable<DetailsMovie> movieId = $movieId")
            MovieDetailScreen(
                movieId = detail.movieId ?: 0,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                navController = navController
            )
        }
    }
}