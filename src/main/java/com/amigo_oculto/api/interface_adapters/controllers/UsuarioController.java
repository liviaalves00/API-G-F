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


import com.amigo_oculto.api.entities.*;
import com.amigo_oculto.api.Aplicattion.use_cases.implementation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
     @Autowired
    private  GerenciarUsuarios gerenciarUsuarios;

    public UsuarioController(GerenciarUsuarios gerenciarUsuarios) {
        this.gerenciarUsuarios = gerenciarUsuarios;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarProduto(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(gerenciarUsuarios.criar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarProdutos() {
        return ResponseEntity.ok(gerenciarUsuarios.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return gerenciarUsuarios.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarProduto(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(gerenciarUsuarios.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        gerenciarUsuarios.deletar(id);
        return ResponseEntity.noContent().build();
    }
}