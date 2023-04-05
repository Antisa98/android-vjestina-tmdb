package endava.codebase.android.movieapp.ui.favorites.mapper

import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.ui.favorites.FavoritesMovieViewState
import endava.codebase.android.movieapp.ui.favorites.FavoritesViewState


class FavoritesMapperImpl : FavoritesMapper {
    override fun toFavoritesViewState(favoriteMovies: List<Movie>): FavoritesViewState {
        val listOfFavoriteMovies = FavoritesViewState(listOfFavorites = favoriteMovies.map {
            FavoritesMovieViewState(
                id = it.id,
                imageUrl = it.imageUrl,
                isFavorite = it.isFavorite
            )
        })

        return listOfFavoriteMovies
    }

}