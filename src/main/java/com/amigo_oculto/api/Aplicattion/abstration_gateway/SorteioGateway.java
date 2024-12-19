package com.amigo_oculto.api.Aplicattion.abstration_gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.amigo_oculto.api.entities.*;;



public interface SorteioGateway {
    Sorteio salvar(Sorteio produto);
    List<Sorteio> listarTodos();
    Optional<Sorteio> buscarPorId(Long id);
    void deletar(Long id);
}
