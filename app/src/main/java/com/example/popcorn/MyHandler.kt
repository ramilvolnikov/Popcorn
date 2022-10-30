package com.example.popcorn

import com.example.popcorn.model.local_dto.FavouriteItems
import com.example.popcorn.viewmodels.FavouriteViewModel
import com.example.popcorn.viewmodels.ItemsModel

class MyHandler {

    fun onEnabled(viewModel: ItemsModel?, favouriteViewModel: FavouriteViewModel, enabled: Boolean) {
            if (enabled && viewModel != null){

                var isTheSame = false

                favouriteViewModel.articles.value?.forEach {
                    if (it.id == viewModel.id){
                        isTheSame = true
                    }
                }

                if (isTheSame)
                    return

                favouriteViewModel.addItem(FavouriteItems().apply {
                    this.id = viewModel.id ?: ""
                    this.rank = viewModel.rank ?: ""
                    this.rankUpDown = viewModel.rankUpDown ?: ""
                    this.title = viewModel.title ?: ""
                    this.fullTitle = viewModel.fullTitle ?: ""
                    this.year = viewModel.year ?: ""
                    this.image = viewModel.image ?: ""
                    this.crew = viewModel.crew ?: ""
                    this.imDbRating = viewModel.imDbRating ?: ""
                    this.imDbRatingCount = viewModel.imDbRatingCount ?: ""
                })
            }else if (viewModel != null){
                favouriteViewModel.deleteMovie(FavouriteItems().apply {
                    this.id = viewModel.id ?: ""
                    this.rank = viewModel.rank ?: ""
                    this.rankUpDown = viewModel.rankUpDown ?: ""
                    this.title = viewModel.title ?: ""
                    this.fullTitle = viewModel.fullTitle ?: ""
                    this.year = viewModel.year ?: ""
                    this.image = viewModel.image ?: ""
                    this.crew = viewModel.crew ?: ""
                    this.imDbRating = viewModel.imDbRating ?: ""
                    this.imDbRatingCount = viewModel.imDbRatingCount ?: ""
                })
            }

        }
}