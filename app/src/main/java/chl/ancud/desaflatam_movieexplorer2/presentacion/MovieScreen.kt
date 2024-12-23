package chl.ancud.desaflatam_movieexplorer2.presentacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chl.ancud.desaflatam_movieexplorer2.modelos.Movie
import chl.ancud.desaflatam_movieexplorer2.modelos.MovieViewModel
import coil3.compose.AsyncImage


@Composable
fun MovieScreen(
    viewModel: MovieViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            uiState.error != null -> {
                Text("ERROR type ${uiState.error}")
            }
            else ->  {
                MovieList(uiState.movies)
            }
        }

        Button(onClick ={ viewModel.loadMovies() }) {
            Text("Load")
        }

    }
}

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card {
        Column {
            Text(movie.title)
            Spacer(modifier = Modifier.padding(8.dp))
            AsyncImage(
                model = movie.poster(),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(movie.overview)
        }
    }
}