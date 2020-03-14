package com.minhbka.recyclerviewmvvm.data.network

import com.minhbka.recyclerviewmvvm.ui.movies.MoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    @GET("movies")
    suspend fun getMovies():Response<MoviesResponse>
    companion object{
        operator fun invoke(): MovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.219.106/MyApi/public/")
                .build()
                .create(MovieApi::class.java)
        }
    }
}