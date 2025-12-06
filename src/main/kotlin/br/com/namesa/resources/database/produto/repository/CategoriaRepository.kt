package br.com.namesa.resources.database.produto.repository

import br.com.namesa.domain.produto.entities.Categoria
import br.com.namesa.resources.database.loja.entities.LojaEntity
import br.com.namesa.resources.database.produto.entities.CategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoriaRepository : JpaRepository<CategoriaEntity, UUID> {

    fun findAllByLoja(loja: LojaEntity): List<CategoriaEntity>
}