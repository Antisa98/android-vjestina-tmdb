package endava.codebase.android.movieapp.ui.home.mapper

import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.model.MovieCategory
import endava.codebase.android.movieapp.ui.component.MovieCategoryLabelViewState
import endava.codebase.android.movieapp.ui.home.HomeMovieCategoryViewState

class HomeScreenMapperImpl : HomeScreenMapper {
    override fun toHomeMovieCategoryViewState(
        movieCategories: List<MovieCategory>,
        selectedMovieCategory: MovieCategory,
        movies: List<Movie>
    ): HomeMovieCategoryViewState {

        return HomeMovieCategoryViewState( movieCategories = movieCategories.map { MovieCategoryLabelViewState(itemId = it.)  })
    }
}