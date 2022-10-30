package com.example.popcorn.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popcorn.model.local_dto.MoviesItems
import com.example.popcorn.repositories.interfaces.IItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val repository: IItemsRepository) : ViewModel() {

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

    fun addItem(item: MoviesItems) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(item)
        }
    }
}