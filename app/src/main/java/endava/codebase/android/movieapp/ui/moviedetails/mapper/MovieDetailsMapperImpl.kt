package endava.codebase.android.movieapp.ui.moviedetails.mapper

import endava.codebase.android.movieapp.model.MovieDetails
import endava.codebase.android.movieapp.ui.component.ActorCardViewState
import endava.codebase.android.movieapp.ui.component.CrewmanViewState
import endava.codebase.android.movieapp.ui.moviedetails.MovieDetailsViewState

class MovieDetailsMapperImpl : MovieDetailsMapper {
    override fun toMovieDetailsViewState(movieDetails: MovieDetails): MovieDetailsViewState {
        return MovieDetailsViewState(
            id = movieDetails.movie.id,
            imageUrl = movieDetails.movie.imageUrl,
            voteAverage = movieDetails.voteAverage,
            title = movieDetails.movie.title,
            overview = movieDetails.movie.overview,
            isFavorite = movieDetails.movie.isFavorite,
            crew = movieDetails.crew.map {
                CrewmanViewState(
                    id = it.id,
                    name = it.name,
                    jobTitle = it.job
                )
            },
            cast = movieDetails.cast.map {
                ActorCardViewState(
                    id = it.id,
                    imageUrl = it.imageUrl,
                    name = it.name,
                    character = it.character
                )
            }
        )
    }


}