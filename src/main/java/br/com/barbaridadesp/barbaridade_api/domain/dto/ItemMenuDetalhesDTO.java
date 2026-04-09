package br.com.barbaridadesp.barbaridade_api.domain.dto;

import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ItemMenuDetalhesDTO {

    CategoriaItemMenu categoria;
    String descricaoCategoria;
    List<Item> itens;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Item {
        UUID uuidItemMenu;
        String base64Image;
        String descricaoAltImage;
        String nome;
        String descricao;

        public Item(ItemMenu entity) {
            this.uuidItemMenu = entity.getUuid();
            this.base64Image = entity.getBase64Image();
            this.descricaoAltImage = entity.getDescricaoAltImage();
            this.nome = entity.getNome();
            this.descricao = entity.getDescricao();
        }
    }

    public ItemMenuDetalhesDTO(ItemMenu entity) {
        this.categoria = entity.getCategoria();
        this.descricaoCategoria = entity.getCategoria().getDescricao();
    }

}