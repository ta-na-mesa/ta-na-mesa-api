package br.com.namesa.domain.produto.services

import br.com.namesa.domain.extensions.WithLog
import br.com.namesa.domain.produto.entities.Categoria
import br.com.namesa.domain.produto.gateway.ProdutoGateway
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class ProdutoServiceImpl(
    private val produtoGateway: ProdutoGateway
) : ProdutoService, WithLog {

    override fun buscarProdutosPorLoja(lojaId: UUID): List<Categoria> = runCatching {
        produtoGateway.buscarProdutosAgrupadosPorCategoriaPorLoja(lojaId)
    }.onSuccess { log.info("[{}] - Retornados {} categorias", lojaId, it.size) }
        .onFailure { log.error("[{}] - Erro ao buscar produtos por categoria", lojaId, it) }
        .getOrThrow()

}