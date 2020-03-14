package com.minhbka.recyclerviewmvvm.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhbka.recyclerviewmvvm.data.repository.MovieRepository

class MoviesViewModelFactory(
    private val repository: MovieRepository
):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}