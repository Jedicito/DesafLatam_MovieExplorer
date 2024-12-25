package chl.ancud.desaflatam_movieexplorer2.presentacion.navegacion

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import chl.ancud.desaflatam_movieexplorer2.modelos.MovieViewModel
import chl.ancud.desaflatam_movieexplorer2.presentacion.MovieScreen

@Composable
fun NavigationWrapper(viewModel: MovieViewModel) {
    val navComtroller = rememberNavController()
    NavHost(navController = navComtroller, startDestination = ListaMovies) {
        composable<ListaMovies> {
            MovieScreen(
                viewModel = viewModel
            )
        }
    }


}