package endava.codebase.android.movieapp.ui.favorites

data class FavoritesMovieViewState(
    val id: Int,
    val imageUrl: String?,
    val isFavorite: Boolean,
)

data class FavoritesViewState(
    val listOfFavorites: List<FavoritesMovieViewState>
)
