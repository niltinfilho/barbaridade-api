package br.com.barbaridadesp.barbaridade_api.domain.entity;

import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity()
@Table(name = "item_menu")
public class ItemMenu extends GenericModel {

    @Column(name = "base_64_img", nullable = false)
    private String base64Img;

    @Column(name = "alt_description", nullable = false)
    private String altDescription;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaItemMenu categoria;
}
