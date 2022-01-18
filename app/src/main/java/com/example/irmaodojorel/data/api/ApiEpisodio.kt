package com.example.irmaodojorel.data.api

import com.example.irmaodojorel.data.model.Episodios
import retrofit2.Call
import retrofit2.http.GET

interface ApiEpisodio {

    @GET("Episodio")
    fun getEpisodios() : Call<List<Episodios>>
}