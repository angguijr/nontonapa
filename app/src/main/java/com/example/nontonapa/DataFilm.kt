package com.example.nontonapa

data class DataFilm(
    val page: Int,
    val result: List<film>
)

data class film(
    val duration: String,
    val genre: List<String>,
    val quality: String,
    val rating: String,
    val thumbnail: String,
    val title: String,
    val trailer: String,
    val watch: String
)