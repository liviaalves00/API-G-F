package com.amigo_oculto.api.entities;

public class Sorteio {
    private Long id;
    private Long eventoId;
    private Long doadorId;
    private Long receptorId;

    // Construtor
    public Sorteio(Long id, Long eventoId, Long doadorId, Long receptorId) {
        this.id = id;
        this.eventoId = eventoId;
        this.doadorId = doadorId;
        this.receptorId = receptorId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Long doadorId) {
        this.doadorId = doadorId;
    }

    public Long getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(Long receptorId) {
        this.receptorId = receptorId;
    }
}
