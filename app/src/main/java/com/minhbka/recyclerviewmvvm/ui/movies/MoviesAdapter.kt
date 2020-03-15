package com.minhbka.recyclerviewmvvm.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minhbka.recyclerviewmvvm.R
import com.minhbka.recyclerviewmvvm.data.models.Movie
import com.minhbka.recyclerviewmvvm.databinding.RecycleviewMovieBinding

class MoviesAdapter(

    private val movies:List<Movie>,
    private val listener: RecycleViewClickListener

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

        holder.recycleViewMovieBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recycleViewMovieBinding.buttonBook, movies[position])
        }
        holder.recycleViewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recycleViewMovieBinding.layoutLike, movies[position])
        }

    }


    inner class MoviesViewHolder(
        val recycleViewMovieBinding: RecycleviewMovieBinding
    ): RecyclerView.ViewHolder(recycleViewMovieBinding.root)
}