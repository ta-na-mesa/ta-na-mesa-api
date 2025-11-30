package br.com.namesa.domain.produto.entities

import java.io.InputStream
import java.math.BigDecimal
import java.util.UUID

data class Produto(
    val id: UUID?,
    val nome: String,
    val descricao: String?,
    val valor: BigDecimal,
    val miniatura: InputStream,
)
