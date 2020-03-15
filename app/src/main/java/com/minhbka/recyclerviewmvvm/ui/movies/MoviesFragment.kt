package com.minhbka.recyclerviewmvvm.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.minhbka.recyclerviewmvvm.R
import com.minhbka.recyclerviewmvvm.data.models.Movie
import com.minhbka.recyclerviewmvvm.data.network.MovieApi
import com.minhbka.recyclerviewmvvm.data.repository.MovieRepository
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(), RecycleViewClickListener {


    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MovieApi()
        val repository = MovieRepository(api)
        factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer {movies->
            recycle_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies, this)
            }

        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book ->{
                Toast.makeText(requireContext(), "Button Book is Clicked", Toast.LENGTH_SHORT).show()

            }
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Button Layout Like is Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
