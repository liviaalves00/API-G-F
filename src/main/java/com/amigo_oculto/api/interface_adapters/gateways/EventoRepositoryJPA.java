package com.amigo_oculto.api.interface_adapters.gateways;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.amigo_oculto.api.Aplicattion.abstration_gateway.EventoGateway;
import com.amigo_oculto.api.entities.Evento;
import com.amigo_oculto.api.interface_adapters.repositories.EventoEntity;
import com.amigo_oculto.api.interface_adapters.repositories.InterfaceEventoJpaRepository;

@Repository
public class EventoRepositoryJPA implements EventoGateway {

    private final InterfaceEventoJpaRepository jpaRepository;

    public EventoRepositoryJPA(InterfaceEventoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Evento salvar(Evento evento) {
        EventoEntity entity = mapToEntity(evento);
        EventoEntity savedEntity = jpaRepository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public List<Evento> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Evento> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }

    private EventoEntity mapToEntity(Evento evento) {
        EventoEntity entity = new EventoEntity();
        entity.setId(evento.getId());
        entity.setNome(evento.getNome());
        entity.setData(evento.getData());
        entity.setDescricao(evento.getDescricao());
        entity.setValorSugerido(evento.getValorSugerido());
        return entity;
    }

    private Evento mapToDomain(EventoEntity entity) {
        return new Evento(
                entity.getId(),
                entity.getNome(),
                entity.getData(),
                entity.getDescricao(),
                entity.getValorSugerido()
        );
    }
}