package chl.ancud.desaflatam_movieexplorer2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import chl.ancud.desaflatam_movieexplorer2.modelos.MovieViewModel
import chl.ancud.desaflatam_movieexplorer2.presentacion.navegacion.NavigationWrapper
import chl.ancud.desaflatam_movieexplorer2.ui.theme.DesafLatam_MovieExplorer2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MovieViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            DesafLatam_MovieExplorer2Theme {
                NavigationWrapper(viewModel)
            }
        }
    }
}
