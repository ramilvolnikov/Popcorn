package com.example.popcorn.viewmodels

import java.io.Serializable

data class InfoItemsModel (
    var id               : String?,
    var title            : String?,
    var releaseDate      : String?,
    var plot             : String?,
    var image            : String?,
    var trailer          : String?

) : Serializable