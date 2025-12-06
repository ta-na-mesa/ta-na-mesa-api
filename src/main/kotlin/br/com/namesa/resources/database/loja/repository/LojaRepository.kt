package br.com.namesa.resources.database.loja.repository

import br.com.namesa.resources.database.loja.entities.LojaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.UUID

interface LojaRepository : JpaRepository<LojaEntity, UUID> {

    @Query("""
        select l from LojaEntity l where l.id = :id
    """)
    fun buscarPorId(@Param("id") id: UUID): LojaEntity?

}