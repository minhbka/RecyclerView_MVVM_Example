package com.minhbka.recyclerviewmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minhbka.recyclerviewmvvm.databinding.RecycleviewMovieBinding

class MoviesAdapter(

    private val movies:List<Movie>
):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recycleview_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recycleViewMovieBinding.movie = movies[position]
    }


    inner class MoviesViewHolder(
        val recycleViewMovieBinding: RecycleviewMovieBinding
    ): RecyclerView.ViewHolder(recycleViewMovieBinding.root)
}