package com.minhbka.recyclerviewmvvm


data class MoviesResponse(
    val isSuccessful: Boolean,
    val movies: List<Movie>
)