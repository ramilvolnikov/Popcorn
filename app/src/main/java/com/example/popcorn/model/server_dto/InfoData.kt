package com.example.popcorn.model.server_dto

import com.google.gson.annotations.SerializedName

data class InfoData (

    @SerializedName("id"               ) var id               : String?                 = null,
    @SerializedName("title"            ) var title            : String?                 = null,
    @SerializedName("releaseDate"      ) var releaseDate      : String?                 = null,
    @SerializedName("plot"             ) var plot             : String?                 = null,
    @SerializedName("image"            ) var image            : String?                 = null,
    @SerializedName("trailer"          ) var trailer          : Trailer?                = null,
    @SerializedName("ratings"          ) var ratings          : Ratings?                = Ratings(),
    @SerializedName("actorList"        ) var actorList        : ArrayList<ActorList>    = arrayListOf()
    )
