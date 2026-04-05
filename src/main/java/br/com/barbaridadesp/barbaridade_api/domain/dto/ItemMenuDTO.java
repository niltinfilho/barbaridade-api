package br.com.barbaridadesp.barbaridade_api.domain.dto;

import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;

import java.util.UUID;

public record ItemMenuDTO(
        UUID uuidItemMenu,
        String base64Image,
        String descricaoAltImage,
        String nome,
        String descricao,
        CategoriaItemMenu categoria,
        String descricaoCategoria
) {

    public ItemMenuDTO(ItemMenu entity) {
        this(
                entity.getUuid(),
                entity.getBase64Image(),
                entity.getDescricaoAltImage(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getCategoria(),
                entity.getCategoria().getDescricao()
        );
    }
}
