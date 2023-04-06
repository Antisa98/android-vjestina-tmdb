package endava.codebase.android.movieapp.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import endava.codebase.android.movieapp.mock.MoviesMock
import endava.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import endava.codebase.android.movieapp.ui.component.*
import endava.codebase.android.movieapp.ui.moviedetails.MovieDetailsViewState
import endava.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapper
import endava.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapperImpl

// imports
private val movieDetailsMapper: MovieDetailsMapper = MovieDetailsMapperImpl()

// multiple view states if required
val movieDetailsViewState = movieDetailsMapper.toMovieDetailsViewState(MoviesMock.getMovieDetails())


@Composable
fun movieDetailsRoute(
// actions
) {
    val z by remember { mutableStateOf(movieDetailsViewState) }
}

@Composable
fun movieDetailsScreen(
    z: MovieDetailsViewState, modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.TopStart, modifier = modifier) {
        Column(Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                AsyncImage(
                    model = z.imageUrl,
                    contentDescription = "Actor",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                UserScoreProgressBar(
                    z.voteAverage,
                    Modifier
                        .size(70.dp)
                        .align(Alignment.CenterStart)
                )

                Text(
                    text = z.title,
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(vertical = 50.dp)
                )
                val isChecked = remember { mutableStateOf(z.isFavorite) }
                FavoriteButton(
                    isFavorite = isChecked.value,
                    onClick = { isChecked.value = !isChecked.value },
                    Modifier.align(Alignment.BottomStart)
                )
            }

            Text(
                text = "Overview",
                fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
            Text(text = z.overview, fontSize = 12.sp)

            LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.height(125.dp)) {
                items(z.crew) { crew ->
                    CrewmanView(crewmanViewState = crew, modifier = Modifier.size(50.dp))
                }
            }

            Text(
                text = "Top Billed Cast",
                fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .size(100.dp)
            ) {
                items(z.cast) { cast ->
                    ActorCard(
                        actorCardViewState = cast, Modifier.size(width = 130.dp, height = 180.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun movieDetailsScreenPreview() {
    MovieAppTheme {
        movieDetailsScreen(movieDetailsViewState)
    }
}
