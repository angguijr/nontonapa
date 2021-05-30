package com.example.nontonapa.Network

import com.example.nontonapa.DataFilm
import retrofit2.Call
import retrofit2.http.GET

interface api {

    @GET("genre?genre=action\n")
    fun getDataFilm() : Call<DataFilm>

}