package br.com.namesa.domain.produto.services

import br.com.namesa.domain.produto.entities.Categoria
import java.util.UUID

interface ProdutoService {
    fun buscarProdutosPorLoja(lojaId: UUID): List<Categoria>
}