package com.amigo_oculto.api.Aplicattion.use_cases.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.amigo_oculto.api.Aplicattion.abstration_gateway.EventoGateway;
import com.amigo_oculto.api.Aplicattion.use_cases.abstration.InterfaceGerenciarEventos;
import com.amigo_oculto.api.entities.Evento;




@Component
public class GerenciarEventos  implements InterfaceGerenciarEventos {

    private final EventoGateway repository;

    public GerenciarEventos(EventoGateway repository) {
        this.repository = repository;
    }

    public Evento criar(Evento evento) {
        return repository.salvar(evento);
    }

    public List<Evento> listar() {
        return repository.listarTodos();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Evento atualizar(Long id, Evento eventoAtualizado) {
        return repository.buscarPorId(id).map(produto -> {
            Evento atualizado = new Evento(
                produto.getId(),
                eventoAtualizado.getNome(),
                eventoAtualizado.getData(),
                eventoAtualizado.getDescricao(),
                eventoAtualizado.getValorSugerido()
                
            );
            return repository.salvar(atualizado);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));


    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Object criarEvento(Evento evento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarEvento'");
    }

}
