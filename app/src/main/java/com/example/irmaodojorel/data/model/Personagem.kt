package com.example.irmaodojorel.data.model

import java.io.Serializable

 data class Personagem (
    val id: Long,
    val nome: String,
    val imagemUrl: String,
    val categoria: Categoria,
    val idade: String? = null,
    val descricao: String,
    val frase: String? = null,
    val biografia: String? = null,
    val aparencia: String? = null,
    val personalidade: String? = null,
    val vozes: List<Voze>,
    val episodioPersonagems: Any? = null
) : Serializable
