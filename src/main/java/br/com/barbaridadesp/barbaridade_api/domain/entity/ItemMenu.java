package br.com.barbaridadesp.barbaridade_api.domain.entity;

import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item_menu")
public class ItemMenu extends GenericModel {

    @Column(name = "base_64_image", nullable = false)
    private String base64Image;

    @Column(name = "descricao_alt_image", nullable = false)
    private String descricaoAltImage;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaItemMenu categoria;
}
