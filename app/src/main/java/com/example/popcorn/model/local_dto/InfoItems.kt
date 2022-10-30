package com.example.popcorn.model.local_dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Info")
class InfoItems {
    @PrimaryKey(autoGenerate = true)
    var id              : Int = 0
    var title           : String? = ""
    var releaseDate     : String? = ""
    var plot            : String? = ""
    var image           : String? = ""
    var trailer         : String? = ""
}