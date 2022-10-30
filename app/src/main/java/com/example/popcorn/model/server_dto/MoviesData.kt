package com.example.popcorn.model.server_dto

import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("items"        ) var items        : ArrayList<Items> = arrayListOf(),
    @SerializedName("errorMessage" ) var errorMessage : String?          = null
)