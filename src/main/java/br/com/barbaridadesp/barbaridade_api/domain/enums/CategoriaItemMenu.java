package br.com.barbaridadesp.barbaridade_api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoriaItemMenu {
    PETISCOS_E_ACOMPANHAMENTOS("Petiscos e Acompanhamentos"),
    PRATOS_PRINCIPAIS("Pratos Principais"),
    SOBREMESAS("Sobremesas"),
    DRINKS_DA_CASA("Drinks da Casa"),
    CERVEJAS_E_CHOPES("Cervejas e Chopes");

    private final String descricao;
}