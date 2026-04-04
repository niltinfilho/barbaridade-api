package br.com.barbaridadesp.barbaridade_api.domain.dto;

import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;

public record ItemMenuDTO(
        String base64Img,
        String altDescription,
        String nome,
        String descricao,
        CategoriaItemMenu categoria
) {

    public ItemMenuDTO(ItemMenu entity) {
        this(
                entity.getBase64Img(),
                entity.getAltDescription(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getCategoria()
        );
    }
}
