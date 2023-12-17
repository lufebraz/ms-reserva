package com.microserviceone.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;


public class Restaurante {

    private Long id;
    private String nomeRestaurante;
    private String horarioAberto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getHorarioAberto() {
        return horarioAberto;
    }

    public void setHorarioAberto(String horarioAberto) {
        this.horarioAberto = horarioAberto;
    }
}
