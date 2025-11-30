package br.com.namesa.resources.database.produto.entities

import br.com.namesa.resources.database.loja.entities.LojaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "CATEGORIA")
class CategoriaEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "NOME", insertable = true, updatable = true, nullable = false, length = 200)
    var nome: String,

    @Column(name = "DESCRICAO", insertable = true, updatable = true, nullable = true, length = 500)
    var descricao: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOJA", insertable = true, updatable = false, nullable = false)
    val loja: LojaEntity,

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProdutoEntity::class, mappedBy = "categoria")
    val produtos: List<ProdutoEntity> = emptyList()
)