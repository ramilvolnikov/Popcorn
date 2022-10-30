package com.example.popcorn.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popcorn.model.local_dto.FavouriteItems
import com.example.popcorn.repositories.interfaces.IFavouriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val repository: IFavouriteRepository) : ViewModel() {

    val articles: LiveData<List<ItemsModel>>
        get() = Transformations.map(repository.getItems()) { items ->
            return@map items.map { item ->
                ItemsModel(
                    item.id,
                    item.rank,
                    item.rankUpDown,
                    item.title,
                    item.fullTitle,
                    item.year,
                    item.image,
                    item.crew,
                    item.imDbRating,
                    item.imDbRatingCount
                )
            }
        }

    fun clearTable() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearDatabase()
        }
    }

    fun addItem(item: FavouriteItems) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(item)
        }
    }

    fun deleteMovie(item: FavouriteItems) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(item)
        }
    }
}