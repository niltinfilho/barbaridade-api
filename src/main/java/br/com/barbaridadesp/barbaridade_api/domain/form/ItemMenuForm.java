package br.com.barbaridadesp.barbaridade_api.domain.form;

import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;

public record ItemMenuForm(
    String base64Image,
    String descricaoAltImage,
    String nome,
    String descricao,
    CategoriaItemMenu categoria) {
}
