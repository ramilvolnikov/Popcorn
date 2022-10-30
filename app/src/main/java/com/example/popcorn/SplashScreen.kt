package com.example.popcorn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.popcorn.model.local_dto.MoviesItems
import com.example.popcorn.viewmodels.ItemsViewModel
import com.example.popcorn.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
    private val moviesViewModel : MoviesViewModel by viewModels()
    private val itemsViewModel : ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemsViewModel.clearTable()

        lifecycleScope.launch {
            val listOfMovies = moviesViewModel.getMovies()

            val operation = async(Dispatchers.IO) {
                listOfMovies.forEach { items ->
                    itemsViewModel.addItem(MoviesItems().apply {
                        this.id = items.id ?: ""
                        this.rank = items.rank ?: ""
                        this.rankUpDown = items.rankUpDown ?: ""
                        this.title = items.title ?: ""
                        this.fullTitle = items.fullTitle ?: ""
                        this.year = items.year ?: ""
                        this.image = items.image ?: ""
                        this.crew = items.crew ?: ""
                        this.imDbRating = items.imDbRating ?: ""
                        this.imDbRatingCount = items.imDbRatingCount ?: ""
                    }).join()
                }
            }
            operation.await()

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}