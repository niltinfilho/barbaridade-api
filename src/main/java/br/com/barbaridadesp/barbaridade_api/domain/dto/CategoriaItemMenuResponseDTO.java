package br.com.barbaridadesp.barbaridade_api.domain.dto;

import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;

public record CategoriaItemMenuResponseDTO(
        String valor,
        String descricao
) {
    public CategoriaItemMenuResponseDTO(CategoriaItemMenu categoria) {
        this(
                categoria.toString(),
                categoria.getDescricao()
        );
    }
}
