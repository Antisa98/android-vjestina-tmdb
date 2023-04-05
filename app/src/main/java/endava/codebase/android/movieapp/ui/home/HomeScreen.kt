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
import endava.codebase.android.movieapp.model.MovieCategory
import endava.codebase.android.movieapp.ui.component.MovieCard
import endava.codebase.android.movieapp.ui.component.MovieCardViewState
import endava.codebase.android.movieapp.ui.component.MovieCategory
import endava.codebase.android.movieapp.ui.home.HomeMovieCategoryViewState
import endava.codebase.android.movieapp.ui.home.mapper.HomeScreenMapper
import endava.codebase.android.movieapp.ui.home.mapper.HomeScreenMapperImpl

// imports
private val homeScreenMapper: HomeScreenMapper = HomeScreenMapperImpl()

val trendingCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(...)
val newReleasesCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(...)


@Composable
fun homeScreenRoute(
// actions
) {

}

@Composable
fun homeScreen(
    z: HomeMovieCategoryViewState,
    modifier: Modifier = Modifier
) {
    Column() {
        Text(text = "Trending movies")
        Row() {
            MovieCategory(movieCategoryLabelViewState = , onClick = { /*TODO*/ })
            MovieCategory(movieCategoryLabelViewState = MovieCategory.TopRated, onClick = { /*TODO*/ })
        }
    }

}

@Preview
@Composable
fun homeScreenPreview() {
    val isChecked = remember { mutableStateOf(false) }

    MovieAppTheme {
        homeScreen(homeScreenViewState)
    }
}
