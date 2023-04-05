package endava.codebase.android.movieapp.ui.favorites

import androidx.compose.ui.tooling.preview.Preview
import endava.codebase.android.movieapp.mock.MoviesMock
import endava.codebase.android.movieapp.ui.favorites.mapper.FavoritesMapper
import endava.codebase.android.movieapp.ui.favorites.mapper.FavoritesMapperImpl
import endava.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.ui.component.MovieCard
import endava.codebase.android.movieapp.ui.component.MovieCardViewState

// imports
private val favoritesMapper: FavoritesMapper = FavoritesMapperImpl()

// multiple view states if required
val favoritesViewState = favoritesMapper.toFavoritesViewState(MoviesMock.getMoviesList())


@Composable
fun favoritesRoute(
// actions
) {
    val z by remember { mutableStateOf(favoritesViewState) }
    favoritesScreen(
        z,
    )
}

@Composable
fun favoritesScreen(
    z: FavoritesViewState,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxSize()) {
        Text("Favorites", Modifier.padding(16.dp), fontSize = 24.sp)
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
            items(z.listOfFavorites) { movie ->
                val isChecked = remember { mutableStateOf(movie.isFavorite) }
                MovieCard(
                    MovieCardViewState(
                        imageUrl = movie.imageUrl,
                        isFavorite = isChecked.value
                    ),
                    { isChecked.value = !isChecked.value },
                    Modifier.size(width = 90.dp, height = 220.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun favoritesScreenPreview() {
    val isChecked = remember { mutableStateOf(false) }

    MovieAppTheme {
        favoritesScreen(favoritesViewState)
    }
}
