package com.example.irmaodojorel.data.model

data class Episodios(
    val dataEstreia: String,
    val descricao: String,
    val episodioPersonagems: Any,
    val id: Int,
    val links: List<Link>,
    val nome: String,
    val sinopse: String,
    val temporadaId: Int
) {
    operator fun get(position: Int): Any {
        return position
    }
}