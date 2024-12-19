package com.amigo_oculto.api.Aplicattion.use_cases.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.amigo_oculto.api.Aplicattion.abstration_gateway.UsuarioGateway;
import com.amigo_oculto.api.Aplicattion.use_cases.abstration.InterfaceGerenciarUsuarios;
import com.amigo_oculto.api.entities.Usuario;
import com.amigo_oculto.api.entities.Usuario;




@Component
public class GerenciarUsuarios  implements InterfaceGerenciarUsuarios{

    private final UsuarioGateway repository;

    public GerenciarUsuarios(UsuarioGateway repository) {
        this.repository = repository;
    }

    public Usuario criar(Usuario usuario) {
        return repository.salvar(usuario);
    }

    public List<Usuario> listar() {
        return repository.listarTodos();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Usuario atualizar(Long id, Usuario sorteioAtualizado) {
        return repository.buscarPorId(id).map(sorteio -> {
            Usuario atualizado = new Usuario(
                sorteio.getId(),
                sorteioAtualizado.getNome(),
                sorteioAtualizado.getEmail(),
                sorteioAtualizado.getTelefone()
            );
            return repository.salvar(atualizado);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));



    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

}
