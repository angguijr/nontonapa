package com.example.nontonapa.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val base_url = "https://api-lk21.herokuapp.com/"

    val instance : api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(api::class.java)
    }

}