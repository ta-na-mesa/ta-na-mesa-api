package br.com.namesa.resources.database.produto.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "PRODUTO")
class ProdutoEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "NOME", insertable = true, updatable = true, nullable = false, length = 200)
    var nome: String,

    @Column(name = "DESCRICAO", insertable = true, updatable = true, nullable = true, length = 2000)
    var descricao: String?,

    @Column(name = "VALOR", insertable = true, updatable = true, nullable = false, scale = 8, secondPrecision = 2)
    var valor: BigDecimal,

    @Column(name = "MINIATURA", insertable = true, updatable = true, nullable = false)
    var miniatura: ByteArray,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORIA", insertable = true, updatable = true, nullable = true)
    var categoria: CategoriaEntity?,
)