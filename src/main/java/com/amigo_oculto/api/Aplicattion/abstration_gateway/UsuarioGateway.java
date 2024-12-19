
package com.amigo_oculto.api.Aplicattion.abstration_gateway;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.entities.*;;

public interface UsuarioGateway  {
    Usuario salvar(Usuario produto);
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    void deletar(Long id);
}
