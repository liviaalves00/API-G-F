package com.amigo_oculto.api.interface_adapters.mappers;

import com.amigo_oculto.api.interface_adapters.repositories.*;

import com.amigo_oculto.api.entities.*;
import com.amigo_oculto.api.interface_adapters.repositories.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setTelefone(usuario.getTelefone());
        return entity;
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone()
        );
    }
}
