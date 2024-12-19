
package com.amigo_oculto.api.Aplicattion.use_cases.abstration;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.entities.Usuario;

public interface InterfaceGerenciarUsuarios {


    public Usuario criar(Usuario Usuario);

    public List<Usuario> listar();

    public Optional<Usuario> buscarPorId(Long id);

    public Usuario atualizar(Long id, Usuario usuarioAtualizado);

    public void deletar(Long id);
}
