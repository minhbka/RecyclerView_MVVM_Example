package com.minhbka.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class MoviesViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies(){
        val moviesResponse = repository.getMovies()
        _movies.value = moviesResponse.movies
    }
}
