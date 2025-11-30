package br.com.namesa.application.web.dto

import java.math.BigDecimal
import java.util.UUID

data class ProdutoResponseDTO(
    val categorias: List<CategoriaDTO>
) {
    data class CategoriaDTO(
        val nome: String,
        val descricao: String?,
        val produtos: List<ProdutoListagemDTO> = emptyList(),
    )

    data class ProdutoListagemDTO(
        val id: UUID,
        val nome: String,
        val descricao: String?,
        val valor: BigDecimal,
        val miniatura: String,
    )
}
