package br.com.namesa.application.web

import br.com.namesa.application.web.dto.ProdutoResponseDTO
import br.com.namesa.domain.extensions.toBase64String
import br.com.namesa.domain.produto.services.ProdutoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/produtos/v1")
internal class ProdutoController(
    private val produtoService: ProdutoService
) {

    @GetMapping("/categorias/{loja-id}")
    fun adquirirProdutosPorLoja(@PathVariable("loja-id") lojaId: UUID): ResponseEntity<ProdutoResponseDTO> {
        val categorias = produtoService.buscarProdutosPorLoja(lojaId)
        if (categorias.isEmpty()) return ResponseEntity.noContent().build()
        val body = ProdutoResponseDTO(
            categorias = categorias.map { categoria ->
                ProdutoResponseDTO.CategoriaDTO(
                    nome = categoria.nome,
                    descricao = categoria.descricao,
                    produtos = categoria.produtos.map { produto ->
                        ProdutoResponseDTO.ProdutoListagemDTO(
                            id = produto.id!!,
                            nome = produto.nome,
                            descricao = produto.descricao,
                            valor = produto.valor,
                            miniatura = produto.miniatura.toBase64String()
                        )
                    }
                )
            })
        body.categorias.map { it.produtos }
            .flatten()
        return ResponseEntity.ok(
            body
        )
    }
}