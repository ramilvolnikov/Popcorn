package com.example.popcorn.model.local_dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourite")
class FavouriteItems {
    @PrimaryKey(autoGenerate = true)
    var hash            : Int = 0
    var id              : String = ""
    var rank            : String = ""
    var rankUpDown      : String = ""
    var title           : String = ""
    var fullTitle       : String = ""
    var year            : String = ""
    var image           : String = ""
    var crew            : String = ""
    var imDbRating      : String = ""
    var imDbRatingCount : String = ""
}