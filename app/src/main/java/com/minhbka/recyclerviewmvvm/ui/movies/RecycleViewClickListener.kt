package com.minhbka.recyclerviewmvvm.ui.movies

import android.view.View
import com.minhbka.recyclerviewmvvm.data.models.Movie

interface RecycleViewClickListener{
    fun onRecyclerViewItemClick(view: View, movie : Movie)
}