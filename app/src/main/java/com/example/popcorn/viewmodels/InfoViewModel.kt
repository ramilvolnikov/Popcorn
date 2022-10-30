package com.example.popcorn.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popcorn.repositories.interfaces.IInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(private val repository: IInfoRepository) : ViewModel()  {

    suspend fun getPlot(id: String) : String {
        var plot = String()

        viewModelScope.launch(Dispatchers.IO) {
            plot = repository.getInfo(id).plot.toString()
        }.join()

        return plot
    }

    suspend fun getImage(id: String) : String {
        var image = String()

        viewModelScope.launch(Dispatchers.IO) {
            image = repository.getInfo(id).image.toString()
        }.join()

        return image
    }

    suspend fun getTitle(id: String) : String {
        var title = String()

        viewModelScope.launch(Dispatchers.IO) {
            title = repository.getInfo(id).title.toString()
        }.join()

        return title
    }

    suspend fun getReleaseDate(id: String) : String {
        var releaseDate = String()

        viewModelScope.launch(Dispatchers.IO) {
            releaseDate = repository.getInfo(id).releaseDate.toString()
        }.join()

        return releaseDate
    }

    suspend fun getTrailer(id: String) : String {
        var trailer = String()

        viewModelScope.launch(Dispatchers.IO) {
            trailer = repository.getInfo(id).trailer?.linkEmbed.toString()
        }.join()

        return trailer
    }

}