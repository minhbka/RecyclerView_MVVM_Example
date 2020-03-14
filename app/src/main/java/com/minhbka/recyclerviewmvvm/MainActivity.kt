package com.minhbka.recyclerviewmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MovieRepository(MovieApi())
        GlobalScope.launch (Dispatchers.Main){
            val movies = repository.getMovies()
            Log.d("Response:", "$movies")
        }

    }
}
