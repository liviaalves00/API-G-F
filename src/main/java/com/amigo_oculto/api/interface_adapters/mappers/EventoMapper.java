package com.amigo_oculto.api.interface_adapters.mappers;

import java.time.LocalDate;

import com.amigo_oculto.api.entities.Evento;
import com.amigo_oculto.api.interface_adapters.repositories.EventoEntity;
import com.amigo_oculto.api.interface_adapters.repositories.UsuarioEntity;

public class EventoMapper {

    public static EventoEntity toEntity(Evento evento) {
        EventoEntity entity = new EventoEntity();
        entity.setId(evento.getId());
        entity.setNome(evento.getNome());
        entity.setData(evento.getData());
        entity.setDescricao(evento.getDescricao());
        entity.setValorSugerido(evento.getValorSugerido());
        return entity;

    }

    public static Evento toDomain(EventoEntity entity) {
        return new Evento(
                entity.getId(),
                entity.getNome(),
               entity.getData(),
               entity.getDescricao(),
               entity.getValorSugerido()
        );
    }
}

