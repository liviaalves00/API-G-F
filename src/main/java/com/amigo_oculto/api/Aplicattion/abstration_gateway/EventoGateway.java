package com.amigo_oculto.api.Aplicattion.abstration_gateway;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.entities.*;

public interface EventoGateway {
    Evento salvar(Evento evento);
    List<Evento> listarTodos();
    Optional<Evento> buscarPorId(Long id);
    void deletar(Long id);
}
