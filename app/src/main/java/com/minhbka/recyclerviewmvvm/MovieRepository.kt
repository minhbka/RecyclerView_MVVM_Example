package com.minhbka.recyclerviewmvvm

class MovieRepository (
    private val api: MovieApi
):SafeApiRequest(){
    suspend fun getMovies()=api.getMovies()
}