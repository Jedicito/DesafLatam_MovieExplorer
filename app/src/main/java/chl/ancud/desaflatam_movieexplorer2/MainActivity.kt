package chl.ancud.desaflatam_movieexplorer2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import chl.ancud.desaflatam_movieexplorer2.modelos.MovieViewModel
import chl.ancud.desaflatam_movieexplorer2.presentacion.MovieScreen
import chl.ancud.desaflatam_movieexplorer2.ui.theme.DesafLatam_MovieExplorer2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MovieViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            DesafLatam_MovieExplorer2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        MovieScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesafLatam_MovieExplorer2Theme {
        Greeting("Android")
    }
}