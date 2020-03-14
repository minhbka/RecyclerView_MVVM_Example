package com.minhbka.recyclerviewmvvm.ui.movies

import com.minhbka.recyclerviewmvvm.data.models.Movie


data class MoviesResponse(
    val isSuccessful: Boolean,
    val movies: List<Movie>
)