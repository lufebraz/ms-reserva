package com.microserviceone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    private Long id;
    private Long restauranteId;
    private LocalDateTime dataHora;
    private Integer numeroDePessoas;
    private String nomeCliente;
    private String contatoCliente;

    public Reserva() {
    }

    public Reserva(Long id, Long restauranteId, LocalDateTime dataHora, Integer numeroDePessoas, String nomeCliente, String contatoCliente) {
        this.id = id;
        this.restauranteId = restauranteId;
        this.dataHora = dataHora;
        this.numeroDePessoas = numeroDePessoas;
        this.nomeCliente = nomeCliente;
        this.contatoCliente = contatoCliente;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(Integer numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }
}
