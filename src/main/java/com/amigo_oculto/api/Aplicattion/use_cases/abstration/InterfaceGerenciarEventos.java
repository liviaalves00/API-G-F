
package com.amigo_oculto.api.Aplicattion.use_cases.abstration;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.entities.Evento;

public interface InterfaceGerenciarEventos {


    public Evento criar(Evento evento);

    public List<Evento> listar();

    public Optional<Evento> buscarPorId(Long id);

    public Evento atualizar(Long id, Evento eventoAtualizado);

    public void deletar(Long id);
}
