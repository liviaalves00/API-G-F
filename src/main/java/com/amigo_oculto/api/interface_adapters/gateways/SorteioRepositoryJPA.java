package com.amigo_oculto.api.interface_adapters.gateways;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.amigo_oculto.api.Aplicattion.abstration_gateway.SorteioGateway;
import com.amigo_oculto.api.Aplicattion.abstration_gateway.UsuarioGateway;
import com.amigo_oculto.api.entities.Sorteio;
import com.amigo_oculto.api.entities.Usuario;
import com.amigo_oculto.api.interface_adapters.mappers.EventoMapper;
import com.amigo_oculto.api.interface_adapters.mappers.SorteioMapper;
import com.amigo_oculto.api.interface_adapters.mappers.UsuarioMapper;
import com.amigo_oculto.api.interface_adapters.repositories.SorteioEntity;
import com.amigo_oculto.api.interface_adapters.repositories.InterfaceSorteioJpaRepository;

@Component
public class SorteioRepositoryJPA implements SorteioGateway {


     private final InterfaceSorteioJpaRepository jpaRepository;

    public SorteioRepositoryJPA(InterfaceSorteioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Sorteio salvar(Sorteio sorteio) {
        SorteioEntity entity = SorteioMapper.toEntity(sorteio);
        SorteioEntity salvo = jpaRepository.save(entity);
        return SorteioMapper.toDomain(salvo);
    }

    @Override
    public List<Sorteio> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(SorteioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Sorteio> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(SorteioMapper::toDomain);
    }

    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }


}
