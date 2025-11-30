package br.com.namesa.resources.database.produto.gateway

import br.com.namesa.domain.produto.entities.Categoria
import br.com.namesa.domain.produto.gateway.ProdutoGateway
import br.com.namesa.resources.database.loja.repository.LojaRepository
import br.com.namesa.resources.database.produto.entities.CategoriaEntity
import br.com.namesa.resources.database.produto.mapper.toDomain
import br.com.namesa.resources.database.produto.repository.CategoriaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
internal class ProdutoJpaGateway(
    private val lojaRepository: LojaRepository,
    private val categoriaRepository: CategoriaRepository
) : ProdutoGateway {
    override fun buscarProdutosAgrupadosPorCategoriaPorLoja(lojaId: UUID): List<Categoria> {
        val loja = lojaRepository.buscarPorId(lojaId) ?: throw IllegalArgumentException("Loja não encontrada")
        return categoriaRepository.findAllByLoja(loja)
            .map(CategoriaEntity::toDomain)
    }
}