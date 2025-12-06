package br.com.namesa.resources.database.produto.repository

import br.com.namesa.resources.database.produto.entities.ProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProdutoRepository: JpaRepository<ProdutoEntity, UUID> {

}