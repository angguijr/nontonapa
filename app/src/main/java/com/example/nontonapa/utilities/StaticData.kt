package com.example.nontonapa.utilities

import com.example.nontonapa.film

class StaticData {

    companion object {
        var duration: String = ""
        var genre: List<String> = listOf()
        var quality: String = ""
        var rating: String = ""
        var thumbnail: String = ""
        var title: String =""
        var trailer: String = ""
        var watch: String = ""

        fun fill(film: film) {
            duration = film.duration
            genre = film.genre
            quality = film.quality
            rating = film.rating
            thumbnail = film.thumbnail
            title = film.title
            trailer = film.trailer
            watch = film.watch
        }
    }

}