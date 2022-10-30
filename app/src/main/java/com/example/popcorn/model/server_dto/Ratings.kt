package com.example.popcorn.model.server_dto

import com.google.gson.annotations.SerializedName

data class Ratings (

    @SerializedName("imDbId"         ) var imDbId         : String? = null,
    @SerializedName("title"          ) var title          : String? = null,
    @SerializedName("fullTitle"      ) var fullTitle      : String? = null,
    @SerializedName("type"           ) var type           : String? = null,
    @SerializedName("year"           ) var year           : String? = null,
    @SerializedName("imDb"           ) var imDb           : String? = null,
    @SerializedName("metacritic"     ) var metacritic     : String? = null,
    @SerializedName("theMovieDb"     ) var theMovieDb     : String? = null,
    @SerializedName("rottenTomatoes" ) var rottenTomatoes : String? = null,
    @SerializedName("filmAffinity"   ) var filmAffinity   : String? = null,
    @SerializedName("errorMessage"   ) var errorMessage   : String? = null

)