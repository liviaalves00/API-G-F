package com.amigo_oculto.api.entities;

import java.time.LocalDate;

public class Evento {
    private Long id;
    private String nome;
    private LocalDate data;
    private String descricao;
    private Double valorSugerido;

    // Construtor
    public Evento(Long id, String nome, LocalDate data, String descricao, Double valorSugerido) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.valorSugerido = valorSugerido;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(Double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }
}

