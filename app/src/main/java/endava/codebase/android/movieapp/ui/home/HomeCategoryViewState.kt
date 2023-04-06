package endava.codebase.android.movieapp.ui.home

import endava.codebase.android.movieapp.ui.component.MovieCategoryLabelViewState

data class HomeMovieCategoryViewState(
    val movieCategories: List<MovieCategoryLabelViewState>,
    val movies: List<HomeMovieViewState>,
)

data class HomeMovieViewState(
    val id: Int,
    val imageUrl: String?,
    val isFavorite: Boolean,
)

