package com.example.irmaodojorel.data.model

import java.io.Serializable

data class Voze (
    val id: Long,
    val nome: String,
    val personagemID: Long
) : Serializable
