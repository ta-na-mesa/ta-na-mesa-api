package br.com.namesa.domain.produto.entities

import java.util.UUID

data class Categoria(
    val id: UUID?,
    val nome: String,
    val descricao: String?,
    val produtos: List<Produto>
)
