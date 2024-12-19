package com.amigo_oculto.api.interface_adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo_oculto.api.Aplicattion.use_cases.implementation.GerenciarEventos;
import com.amigo_oculto.api.entities.Evento;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private final GerenciarEventos gerenciarEventos;

    public EventoController(GerenciarEventos gerenciarEventos) {
        this.gerenciarEventos = gerenciarEventos;
    }

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(gerenciarEventos.criar(evento));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        return ResponseEntity.ok(gerenciarEventos.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return gerenciarEventos.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return ResponseEntity.ok(gerenciarEventos.atualizar(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        gerenciarEventos.deletar(id);
        return ResponseEntity.noContent().build();
    }
}