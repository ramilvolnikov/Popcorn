package com.example.popcorn.viewmodels

import java.io.Serializable

data class ItemsModel (
    var id              : String,
    var rank            : String,
    var rankUpDown      : String,
    var title           : String,
    var fullTitle       : String,
    var year            : String,
    var image           : String,
    var crew            : String,
    var imDbRating      : String,
    var imDbRatingCount : String
) : Serializable