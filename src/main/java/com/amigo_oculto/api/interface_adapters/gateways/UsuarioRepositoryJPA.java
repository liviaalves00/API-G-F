package com.amigo_oculto.api.interface_adapters.gateways;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.Aplicattion.abstration_gateway.UsuarioGateway;
import com.amigo_oculto.api.entities.Usuario;
import com.amigo_oculto.api.interface_adapters.mappers.UsuarioMapper;
import com.amigo_oculto.api.interface_adapters.repositories.UsuarioEntity;
import com.amigo_oculto.api.interface_adapters.repositories.UsuarioJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryJPA implements UsuarioGateway {

    private final UsuarioJpaRepository jpaRepository;

    public UsuarioRepositoryJPA(UsuarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity salvo = jpaRepository.save(entity);
        return UsuarioMapper.toDomain(salvo);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(UsuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(UsuarioMapper::toDomain);
    }

    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }
}