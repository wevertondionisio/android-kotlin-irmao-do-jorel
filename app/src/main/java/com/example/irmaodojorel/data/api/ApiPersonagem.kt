package com.example.irmaodojorel.data.api

import com.example.irmaodojorel.data.model.Personagem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiPersonagem {

    @GET("Personagem")
    fun listPersonagens() : Call<List<Personagem>>
}