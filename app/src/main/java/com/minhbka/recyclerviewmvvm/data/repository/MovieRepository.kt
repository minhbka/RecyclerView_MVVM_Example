package com.minhbka.recyclerviewmvvm.data.repository

import com.minhbka.recyclerviewmvvm.data.network.MovieApi

class MovieRepository (
    private val api: MovieApi
): SafeApiRequest(){
    suspend fun getMovies()=apiRequest {api.getMovies()}
}