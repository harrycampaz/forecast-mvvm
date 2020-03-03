package com.dezzapps.mrforecast.data.db.entity


import com.google.gson.annotations.SerializedName

data class Request_(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)