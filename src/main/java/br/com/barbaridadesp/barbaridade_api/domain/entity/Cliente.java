package br.com.barbaridadesp.barbaridade_api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends GenericModel {

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

}
