package com.example.popcorn.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popcorn.model.local_dto.InfoItems
import com.example.popcorn.repositories.interfaces.IInfoItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class InfoItemsViewModel constructor(private val repository: IInfoItemsRepository, private var id: String) : ViewModel() {

    val articles: LiveData<InfoItemsModel>
        get() = Transformations.map(repository.getItems(id)) {
            return@map InfoItemsModel(
                it.id.toString(),
                it.title,
                it.releaseDate,
                it.plot,
                it.image,
                it.trailer
            )
        }

    fun clearTable() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearDatabase()
        }
    }

    fun addItem(item: InfoItems) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(item)
        }
    }

}