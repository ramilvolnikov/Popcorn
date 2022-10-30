package com.example.popcorn.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popcorn.model.server_dto.Items
import com.example.popcorn.repositories.interfaces.IMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: IMoviesRepository) : ViewModel()  {

    suspend fun getMovies() : ArrayList<Items> {
        var items = arrayListOf<Items>()

        viewModelScope.launch(Dispatchers.IO) {
            items = repository.getMovies().items
        }.join()

        return items
    }
}