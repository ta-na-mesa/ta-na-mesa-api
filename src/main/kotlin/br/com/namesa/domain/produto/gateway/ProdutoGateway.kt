package br.com.namesa.domain.produto.gateway

import br.com.namesa.domain.produto.entities.Categoria
import java.util.UUID

interface ProdutoGateway {

    fun buscarProdutosAgrupadosPorCategoriaPorLoja(lojaId: UUID): List<Categoria>
}