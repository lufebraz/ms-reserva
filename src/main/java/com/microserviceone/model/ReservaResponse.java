package com.microserviceone.model;

public class ReservaResponse {
    private Long id;
    private String nomeCliente;
    private String contatoCliente;
    private Integer numeroDePessoas;
    private String nomeRestaurante;
    private String dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(Integer numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
