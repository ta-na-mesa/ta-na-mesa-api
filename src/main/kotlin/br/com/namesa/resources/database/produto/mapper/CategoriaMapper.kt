package br.com.namesa.resources.database.produto.mapper

import br.com.namesa.domain.produto.entities.Categoria
import br.com.namesa.domain.produto.entities.Produto
import br.com.namesa.resources.database.produto.entities.CategoriaEntity
import br.com.namesa.resources.database.produto.entities.ProdutoEntity
import java.io.ByteArrayInputStream

fun CategoriaEntity.toDomain(): Categoria = this.let {
    Categoria(
        id = it.id,
        nome = it.nome,
        descricao = it.descricao,
        produtos = it.produtos.map(ProdutoEntity::toDomain)
    )
}

fun ProdutoEntity.toDomain(): Produto = this.let {
    Produto(
        id = it.id,
        nome = it.nome,
        descricao = it.descricao,
        valor = it.valor,
        miniatura = ByteArrayInputStream(it.miniatura)
    )
}