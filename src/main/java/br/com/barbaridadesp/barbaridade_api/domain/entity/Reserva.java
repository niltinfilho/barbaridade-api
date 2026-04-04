package br.com.barbaridadesp.barbaridade_api.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "data_hora_reserva", nullable = false)
    private LocalDateTime dataHoraReserva;

    @Column(name = "qtd_pessoas", nullable = false)
    private Integer qtdPessoas;
}
