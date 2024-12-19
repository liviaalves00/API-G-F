package com.amigo_oculto.api.interface_adapters.mappers;


import java.time.LocalDate;

import com.amigo_oculto.api.entities.Evento;
import com.amigo_oculto.api.entities.Sorteio;
import com.amigo_oculto.api.interface_adapters.repositories.EventoEntity;
import com.amigo_oculto.api.interface_adapters.repositories.SorteioEntity;
import com.amigo_oculto.api.interface_adapters.repositories.UsuarioEntity;

public class SorteioMapper {

    public static SorteioEntity toEntity(Sorteio evento) {
        SorteioEntity entity = new SorteioEntity();
        entity.setId(evento.getId());
        entity.setEventoId(evento.getEventoId());
        entity.setDoadorId(evento.getDoadorId());
        entity.setReceptorId(evento.getReceptorId());
        return entity;

    }

    public static Sorteio toDomain(SorteioEntity entity) {
        return new Sorteio(
                entity.getId(),
                entity.getEventoId(),
                entity.getDoadorId(),
                entity.getReceptorId()
              
        );
    }
}


